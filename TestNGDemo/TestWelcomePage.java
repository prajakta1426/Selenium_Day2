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

public class TestWelcomePage {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/welcome.html");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }


    @Test
    public void validatetWelcomePage(){

        WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(title.getText(),"Welcome!!","Welcome did not Displayed");


        WebElement nameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameField")));
        Assert.assertFalse(nameField.isEnabled(),"Name feild is Enabled");

        WebElement enterNameBtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("enterNameBtn")));
        enterNameBtn.click();
        Assert.assertTrue(enterNameBtn.isEnabled(),"Name feild is not  Enabled");

    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
