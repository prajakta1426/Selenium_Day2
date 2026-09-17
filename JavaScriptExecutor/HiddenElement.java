package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/hiddenElementJavascriptExecutor.html");
        Thread.sleep(3000);
        WebElement hiddenBtn = driver.findElement(By.id("hiddenBtn"));
        Thread.sleep(1000);

        try
        {
            hiddenBtn.click();
            System.out.println("click succeeded on hidden button");
        } catch (Exception e) {
            System.out.println("click failed on hidden button"+e.getClass().getSimpleName());
        }
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();",hiddenBtn);
        String hiddenText = (String) js.executeScript("return arguments[0].textContent;", hiddenBtn);
        System.out.println("Hidden button text : "+hiddenText);
        Thread.sleep(5000);

        String result = driver.findElement(By.id("result")).getText();
        if(result.equals("Hey Your Trasure will be at your doorstep, wait until TOMORROW !"))
            System.out.println("PASS : Hidden button clicked correctly");
        else
            System.out.println("FAIL : Hidden button did NOT get clicked");
        driver.quit();
    }
}
