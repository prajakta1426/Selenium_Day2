package JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.event.MouseEvent;

public class JavaScriptExecutorZoomLevel {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try
        {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            Thread.sleep(5000);
            double zoomLevelBefore = ((Number) js.executeScript("return window.devicePixelRatio;")).doubleValue();
            System.out.println("Current zoom ratio: "+zoomLevelBefore);

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL)
                    .sendKeys(Keys.ADD)
                    .keyUp(Keys.CONTROL).perform();

            double zoomLevelAfter = ((Number) js.executeScript("return window.devicePixelRatio;")).doubleValue();
            System.out.println("Current zoom ratio: "+zoomLevelAfter);
        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
