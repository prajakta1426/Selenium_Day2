package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyboardShortcutDeleteAll {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/keyboardShortcuts.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement sourceText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sourceText")));
        WebElement targetText = driver.findElement(By.id("targetText"));

        sourceText.click();

        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Select 'all' is performed on source container'");

        actions.keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Select 'copy' is performed on source container'");

        targetText.click();
        actions.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Select 'paste' is performed on target container'");

        String result = driver.findElement(By.id("result")).getText();
        if(result.equals("Text copied successfully to Target !")){
            System.out.println("PASS : Message is Displayed Actual message "+result);
        }
        else{
            System.out.println("FAIL : Message is  not Displayed Actual message "+result);
        }

        targetText.click();
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Select 'all' is performed on target container'");

        actions.keyDown(Keys.DELETE).perform();
        String result1 = driver.findElement(By.id("result")).getText();
        if(result1.equals("Text in Target does not match Source yet.")){
            System.out.println("PASS : Message is Displayed Actual message: "+result1);
        }
        else{
            System.out.println("FAIL : Message is  not Displayed Actual message: "+result1);
        }




        driver.quit();
    }
}
