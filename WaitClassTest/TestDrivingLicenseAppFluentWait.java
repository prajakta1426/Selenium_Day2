package WaitClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestDrivingLicenseAppFluentWait {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try{
            webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/welcome.html");

            //Fluent wait
            Wait<WebDriver> obj_fluentwait= new FluentWait<>(webDriver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            WebElement message = obj_fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

            if(message.getText().equals("Welcome!!"))
            {
                System.out.println("PASS: Welcome message is displayed correctly");
            }
            else
                System.out.println("FAIL: Welcome message is mismatch. Actual "+message.getText());

            //explicit wait
            WebDriverWait obj_wait= new WebDriverWait(webDriver,Duration.ofSeconds(10));
            WebElement enterNameBtn = obj_wait.until(ExpectedConditions.elementToBeClickable(By.id("enterNameBtn")));

            if (enterNameBtn.isEnabled())
            {
                System.out.println("PASS : Enter name button is enabled");
            }
            else
                System.out.println("FAIL : Enter button is disabled");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            webDriver.quit();
        }
    }
}
