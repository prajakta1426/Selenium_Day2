package WaitClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePageExplicitWait {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        //implicit wait
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try{

            webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/welcome.html");

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
