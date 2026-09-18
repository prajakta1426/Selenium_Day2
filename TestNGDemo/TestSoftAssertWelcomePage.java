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
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestSoftAssertWelcomePage {
    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/welcome.html");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }


    @Test
    public void validatetWelcomePage(){

        WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        softAssert.assertEquals(title.getText(),"Welcome!!","Welcome did not Displayed");
        System.out.println("Title assertion passed");

        WebElement nameField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameField")));
        softAssert.assertFalse(!nameField.isEnabled(),"Name field is Enabled");
        System.out.println("Name field disabled assertion has passed");

        WebElement enterNameBtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("enterNameBtn")));
        enterNameBtn.click();
        softAssert.assertTrue(enterNameBtn.isEnabled(),"Name field is not  Enabled");
        System.out.println("Name field enabled assertion has passed");

        softAssert.assertAll();

    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
