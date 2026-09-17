package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RightClickContextMenu {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/rightClickContextMenuInteraction.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);


        WebElement targetbox= wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("targetBox"))));
        actions.contextClick(targetbox).perform();

        WebElement contextMenu= wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("contextMenu"))));
        if(contextMenu.isDisplayed()){
            System.out.println("PASS : Context Menu appeared after right click");
        }
        else{
            System.out.println("FAIL : Context Menu did not  appeared after right click");
        }

        WebElement deleteOption= wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteOption")));
        deleteOption.click();

        String deleteresult= "You selected: Delete";
        String result = driver.findElement(By.id("result")).getText();
        if(deleteresult.equals(result)){
            System.out.println("PASS : Message is Displayed Actual message "+result);
        }
        else{
            System.out.println("FAIL : Message is  not Displayed Actual message "+result);
        }
        driver.quit();

    }

}
