package HerokuApp;

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
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/drag_and_drop']"))).click();
        Actions actions = new Actions(driver);

        WebElement columnA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        WebElement columnB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));

        //check if columns are displayed
        if(columnA.isDisplayed()&&columnB.isDisplayed())
            System.out.println("PASS : Both cards are displayed.");
        else
            System.out.println("FAIL : Both cards are not displayed.");

        actions.dragAndDrop(columnA,columnB);

        //check div after elements are switched
        WebElement divA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[text()='B']")));
        WebElement divB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[text()='A']")));

        if(divA.isDisplayed()&&divB.isDisplayed())
            System.out.println("PASS : Drag and drop functionality is successful.");
        else
            System.out.println("FAIL : Drag and drop functionality is unsuccessful.");

        driver.quit();
    }
}
