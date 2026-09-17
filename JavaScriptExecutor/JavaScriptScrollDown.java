package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptScrollDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/hiddenElementJavascriptExecutor.html");

        WebElement scrollTargetBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollTargetBtn")));
        js.executeScript("arguments[0].scrollIntoView(true);",scrollTargetBtn);
        Thread.sleep(2000);
        if (scrollTargetBtn.isDisplayed())
            System.out.println("PASS : Scroll Target Button is displayed");
        else
            System.out.println("FAIL : Scroll Target Button is NOT displayed");

        scrollTargetBtn.click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("result")).getText().trim();
        if(result.equals("Better Luck Next Time :-)"))
            System.out.println("PASS : Text is displayed. Actual : "+result);
        else
            System.out.println("FAIL : Text is NOT displayed. Actual : "+result);
        driver.quit();
    }
}
