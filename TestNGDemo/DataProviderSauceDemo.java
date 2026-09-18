package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DataProviderSauceDemo {
        WebDriver driver;
        WebDriverWait wait;

        By usernameField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By errormessage = By.xpath("//h3[@data-test='error']");

        @DataProvider(name = "loginDataSet")
        public Object[][] getLoginData()
        {
            String csvFilePath = "C:\\Users\\CCST\\Desktop\\SeleniumMaterial\\loginData.csv";
            List<Object[]> records = new ArrayList<>();
            try(BufferedReader br = new BufferedReader(new FileReader(csvFilePath)))
            {
                String line;
                boolean firstLine =true;
                while((line=br.readLine())!=null)
                {
                    if(firstLine){
                        firstLine=false;
                        continue;
                    }
                    if(line.trim().isEmpty())
                        continue;
                    String[] values = line.split(",");
                    String username= values[0].trim();
                    String password= values[1].trim();
                    records.add(new Object[]{username,password});
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return records.toArray(new Object[0][0]);
        }

        @BeforeMethod(groups = {"smoke"})
        public void setup() throws InterruptedException {
            driver = new ChromeDriver();
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            Thread.sleep(1000);
        }

        @Test(priority = 1,groups = {"smoke"}, dataProvider = "loginDataSet")
        public void testPositiveLoginSauceDemo(String username, String password) throws InterruptedException {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);
            WebElement usernamePath = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            WebElement passwordPath = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

            usernamePath.sendKeys(username);
            passwordPath.sendKeys(password);
            login.click();

            wait.until(ExpectedConditions.urlContains("inventory.html"));
            String currentUrl = driver.getCurrentUrl();

            Assert.assertTrue(currentUrl.contains("inventory.html"),
                    "Login failed. URL"+currentUrl);

        }

        @AfterMethod(groups = {"smoke"})
        public void teardown()
        {
            if(driver!=null)
                driver.quit();
        }

}
