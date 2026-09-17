package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/dragDrop.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions = new Actions(driver);

            WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item1")));
            WebElement targetContainer = driver.findElement(By.id("targetContainer"));
            //using dragAndDrop
            actions.dragAndDrop(item1, targetContainer).perform();

            String result = driver.findElement(By.id("result")).getText();
            if (result.contains("Write Manual Testcases moved to Done"))
                System.out.println("PASS : Drag and drop worked");
            else
                System.out.println("FAIL : Drag and drop did not work");
            Thread.sleep(3000);

            //using move to element from actions class
            WebElement item2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item2")));
            actions.clickAndHold(item2)
                    .moveToElement(targetContainer)
                    .pause(Duration.ofMillis(300))
                    .release()
                    .build()
                    .perform();
            String result2 = driver.findElement(By.id("result")).getText();
            if (result2.contains("Define Entry and Exit Criteria moved to Done"))
                System.out.println("PASS : Drag and drop worked");
            else
                System.out.println("FAIL : Drag and drop did not work");
            ////////////////////////////////////////////////////////////////////
            //moved back to TO DOs

            WebElement sourceContainer = driver.findElement(By.id("sourceContainer"));
            actions.dragAndDrop(item1, sourceContainer).perform();

            String result3 = driver.findElement(By.id("result")).getText();
            if (result3.contains("Write Manual Testcases moved to TO DO"))
                System.out.println("PASS : Drag and drop worked");
            else
                System.out.println("FAIL : Drag and drop did not work");
            Thread.sleep(3000);

            actions.clickAndHold(item2)
                    .moveToElement(sourceContainer)
                    .pause(Duration.ofMillis(300))
                    .release()
                    .build()
                    .perform();
            String result4 = driver.findElement(By.id("result")).getText();
            if (result4.contains("Define Entry and Exit Criteria moved to TO DO"))
                System.out.println("PASS : Drag and drop worked");
            else
                System.out.println("FAIL : Drag and drop did not work");

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
