package WaitClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestDrivingLicenseAppExplicitWait {
    public static void main(String[] args) {
    WebDriver webDriver = new ChromeDriver();
    //implicit wait
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    try{

        webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/welcome.html");

        //explicit wait
        WebDriverWait obj_wait= new WebDriverWait(webDriver,Duration.ofSeconds(10));
        WebElement message = obj_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        if(message.getText().equals("Welcome!!"))
        {
            System.out.println("PASS: Welcome message is displayed correctly");
        }
        else
           System.out.println("FAIL: Welcome message is mismatch. Actual "+message.getText());


    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    finally {
        webDriver.quit();
    }
}
}
