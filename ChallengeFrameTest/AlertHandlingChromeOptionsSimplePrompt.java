package ChallengeFrameTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandlingChromeOptionsSimplePrompt {
    public static void main(String[] args) {
        //configure driver to auto handle unexpected alerts
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior","accept");

        WebDriver driver = new ChromeDriver(options);
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/javascriptAlerts.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //clicking on show alert
        driver.findElement(By.id("alertBtn")).click();

        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = simpleAlert.getText();
        System.out.println("Alert text : "+alertText);

        simpleAlert.accept();

        String alertResult = driver.findElement(By.id("alertResult")).getText();
        if(alertResult.equals("Alert was shown and accepted."))
        {
            System.out.println("PASS : Simple Alert message is displayed. Actual Message "+alertResult);
        }
        else
            System.out.println("FAIL : Simple Alert message is not displayed. Actual Message "+alertResult);

        //clicking on show confirm
        driver.findElement(By.id("confirmBtn")).click();
        driver.quit();
    }
}
