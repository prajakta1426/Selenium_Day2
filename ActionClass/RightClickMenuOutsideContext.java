package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RightClickMenuOutsideContext {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/rightClickContextMenuInteraction.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement outsideContext= driver.findElement(By.tagName("h2"));
        actions.contextClick(outsideContext).perform();

        Boolean contextMenu= wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("contextMenu"))));
        if(contextMenu){
            System.out.println("PASS : Context Menu has not appeared after right click outside box");
        }
        else{
            System.out.println("FAIL : Context Menu has appeared after right click");
        }
        driver.quit();
    }
}
