package JavaScriptAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlerts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
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

        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        String confirmBtnAlertMessage = confirmAlert.getText();
        System.out.println("Confirm Alert text is : "+confirmBtnAlertMessage);
        confirmAlert.accept();

        String alertconfirmBtnResult = driver.findElement(By.id("confirmResult")).getText();
        if(alertconfirmBtnResult.equals("You clicked OK."))
        {
            System.out.println("PASS : Confirm Alert message is displayed. Actual Message "+alertconfirmBtnResult);
        }
        else
            System.out.println("FAIL : Confirm Alert message is not displayed. Actual Message "+alertconfirmBtnResult);

        //clicking on show prompt button
        driver.findElement(By.id("promptBtn")).click();

        Alert promptBtnAlert = wait.until(ExpectedConditions.alertIsPresent());
        String test = "This is a test";
        promptBtnAlert.sendKeys(test);
        promptBtnAlert.accept();

        String alertPromptBtnResult = driver.findElement(By.id("promptResult")).getText();
        if(alertPromptBtnResult.equals("You entered: "+test))
        {
            System.out.println("PASS : Prompt Alert message is displayed. Actual Message "+alertPromptBtnResult);
        }
        else
            System.out.println("FAIL : Prompt Alert message is not displayed. Actual Message "+alertPromptBtnResult);

        driver.quit();
    }
}
