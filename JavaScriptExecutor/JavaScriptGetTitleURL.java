package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScriptGetTitleURL {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/hiddenElementJavascriptExecutor.html");

        String title = (String) js.executeScript("return document.title;");
        if(title.equals("JavascriptExecutor Demo - Scroll & Hidden Click"))
            System.out.println("PASS : Title matched. Actual : "+title);
        else
            System.out.println("FAIL : Title mismatched. Actual : "+title);
        driver.quit();
    }
}
