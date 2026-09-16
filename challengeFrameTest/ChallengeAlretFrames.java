package challengeFrameTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ChallengeAlretFrames {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try{

            webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/challenge_AlertsFrames.html");

            //original window handle
            String parentWindow = webDriver.getWindowHandle();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));

            //Main Alert Button
            webDriver.findElement(By.id("mainAlertBtn")).click();

            Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = simpleAlert.getText();
            System.out.println("Alert text : "+alertText);
            simpleAlert.accept();
            String alertResult = webDriver.findElement(By.id("mainAlertResult")).getText();
            if(alertResult.equals("Main page alert accepted."))
            {
                System.out.println("PASS : Main page alert message is displayed. Actual Message "+alertResult);
            }
            else
                System.out.println("FAIL : Main page alert message is not displayed. Actual Message "+alertResult);

            //Frame with confirm dialog
            webDriver.switchTo().frame(0);
            WebElement frameConfirmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("frameConfirmBtn")));
            frameConfirmBtn.click();
            Alert frameAlert = wait.until(ExpectedConditions.alertIsPresent());
            String frameAlertText = frameAlert.getText();
            System.out.println("Alert text : "+frameAlertText);
            frameAlert.dismiss();

            String frameConfirmResult = webDriver.findElement(By.id("frameConfirmResult")).getText();
            if(frameConfirmResult.equals("Cancelled inside frame!"))
            {
                System.out.println("PASS : Frame alert message is displayed. Actual Message "+frameConfirmResult);
            }
            else
                System.out.println("FAIL : Frame alert message is not displayed. Actual Message "+frameConfirmResult);
            webDriver.switchTo().defaultContent();

            //New Window with Prompt Dialog
            WebElement openWindowBtn = webDriver.findElement(By.cssSelector("#openWindowBtn"));
            openWindowBtn.click();

            Set<String> windowHandles = webDriver.getWindowHandles();
            String currentWindow = null;
            for(String windowHandle : windowHandles)
            {
                if(!windowHandle.equals(parentWindow))
                {
                    webDriver.switchTo().window(windowHandle);
                    currentWindow = webDriver.getWindowHandle();
                }
            }
            if(webDriver.getTitle().equals("New Window"))
            {
                System.out.println("PASS : Switched to new Window : Title "+webDriver.getTitle());
            }
            else
            {
                System.out.println("FAIL : Did not Switched to new Window : Title "+webDriver.getTitle());
            }

            WebElement newWindowPromptBtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("newWindowPromptBtn")));
            newWindowPromptBtn.click();
            Alert promptalert=wait.until(ExpectedConditions.alertIsPresent());
            promptalert.sendKeys("This is a test.");
            promptalert.accept();

            String newWindowResult = webDriver.findElement(By.id("newWindowResult")).getText();
            if(newWindowResult.equals("You entered: This is a test."))
            {
                System.out.println("PASS : new Window prompt alert message is displayed. Actual Message "+newWindowResult);
            }
            else
                System.out.println("FAIL : new Window prompt alert message is not displayed. Actual Message "+newWindowResult);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally{
            webDriver.quit();
        }
    }
}
