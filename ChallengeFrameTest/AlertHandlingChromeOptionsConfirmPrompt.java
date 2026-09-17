package ChallengeFrameTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandlingChromeOptionsConfirmPrompt {
    public static void main(String[] args) {
        ChromeOptions options =new ChromeOptions();
        options.setCapability("unhandledPromptBehavior","dismiss");
        WebDriver driver = new ChromeDriver(options);

        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/javascriptAlerts.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(By.id("confirmBtn")).click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alertbtn= wait.until(ExpectedConditions.alertIsPresent());
        alertbtn.accept();

        String alertconfirmBtnResult = driver.findElement(By.id("confirmResult")).getText();
        if(alertconfirmBtnResult.equals("You clicked OK."))
        {
            System.out.println("PASS : Confirm Alert message is displayed. Actual Message "+alertconfirmBtnResult);
        }
        else
            System.out.println("FAIL : Confirm Alert message is not displayed. Actual Message "+alertconfirmBtnResult);


        driver.findElement(By.id("promptBtn")).click();
        Alert promptBtn=wait.until(ExpectedConditions.alertIsPresent());
        String prompt = "This is for prompt";
        promptBtn.sendKeys(prompt);
        promptBtn.accept();

        String alertPromptBtnResult = driver.findElement(By.id("promptResult")).getText();
        if(alertPromptBtnResult.equals("You entered: "+prompt))
        {
            System.out.println("PASS : Prompt Alert message is displayed. Actual Message "+alertPromptBtnResult);
        }
        else
            System.out.println("FAIL : Prompt Alert message is not displayed. Actual Message "+alertPromptBtnResult);

        driver.quit();
    }
}
