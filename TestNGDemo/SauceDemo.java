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
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemo {
        WebDriver driver;
        WebDriverWait wait;

        By usernameField = By.id("user-name");
        By passwordField = By.id("password");
        By loginButton = By.id("login-button");
        By errormessage = By.xpath("//h3[@data-test='error']");

        @BeforeMethod
        public void setup() throws InterruptedException {
            driver = new ChromeDriver();
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            Thread.sleep(1000);
        }

        @Test
        public void testPositiveLoginSauceDemo() throws InterruptedException {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            login.click();

            wait.until(ExpectedConditions.urlContains("inventory.html"));
            String currentUrl = driver.getCurrentUrl();

            Assert.assertTrue(currentUrl.contains("inventory.html"),
                    "Login failed. URL"+currentUrl);

        }

        @AfterMethod
        public void teardown()
        {
            if(driver!=null)
                driver.quit();
        }

}
