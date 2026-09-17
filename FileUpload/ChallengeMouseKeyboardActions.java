package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChallengeMouseKeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/challenge_MouseKeyboardActions.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement documentsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("documentsMenu")));
        actions.moveToElement(documentsMenu).perform();

        WebElement uploadDocLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadDocLink")));
        if(uploadDocLink.isDisplayed())
        {
            System.out.println("PASS : Upload link is displayed");
        }
        else
            System.out.println("FAIL : Upload link is not displayed");
        uploadDocLink.click();

        WebElement uploadSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadSection")));
        if(uploadSection.isDisplayed())
        {
            System.out.println("PASS : Scrolled to Upload document section");
        }
        else
            System.out.println("FAIL : Upload document section is not displayed");


        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileInput")));
        String filePath="C:\\Users\\CCST\\Desktop\\SeleniumMaterial\\welcome.html";
        fileInput.sendKeys(filePath);
        Thread.sleep(3000);
        System.out.println("File path sent to input field");


        WebElement fileNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileName")));
        if(fileNameLabel.getText().contains("Selected file: welcome.html"))
            System.out.println("PASS : File has been uploaded. Message : "+fileNameLabel.getText());
        else
            System.out.println("FAIL : File has NOT been uploaded. Message : "+fileNameLabel.getText());

        driver.findElement(By.id("uploadBtn")).click();
        Thread.sleep(3000);

        String result = driver.findElement(By.id("result")).getText();
        if(result.equals("You greedy fellow !!")){
            System.out.println("PASS : Message is Displayed Actual message "+result);
        }
        else{
            System.out.println("FAIL : Message is  not Displayed Actual message "+result);
        }

        driver.quit();
    }
}
