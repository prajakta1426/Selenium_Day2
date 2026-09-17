package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightHeading {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
        Thread.sleep(3000);
        WebElement obj_heading = driver.findElement(By.xpath("//h2[text()='Driving License Application']"));

        js.executeScript("arguments[0].style.border='3px solid red';",obj_heading);
        Thread.sleep(3000);
        driver.quit();
    }
}
