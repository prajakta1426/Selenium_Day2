package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class AddRemoveElementsTest {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try {

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            webDriver.get("https://the-internet.herokuapp.com");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add/Remove Elements']"))).click();

            WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Element']")));
            if (addElement.isEnabled()) {
                System.out.println("PASS : Add Element button is clickable ");
                addElement.click();
                System.out.println("PASS : Add Element button is clicked ");
            } else
                System.out.println("FAIL : Add Element button is not clickable ");

            WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
            if (deleteElement.isDisplayed()) {
                System.out.println("PASS : Delete Element button is displayed ");
            } else
                System.out.println("FAIL : Delete Element button is not displayed ");

            //delete element

            deleteElement.click();
           //Boolean deletedElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
            Boolean deletedElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#elements > button")));
            if (deletedElement) {
                System.out.println("PASS : Delete Element button is removed");
            } else
                System.out.println("FAIL : Delete Element button is not removed");


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally {
            webDriver.quit();
        }
    }
}
