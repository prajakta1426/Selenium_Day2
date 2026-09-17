package HerokuApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/dynamic_loading']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/dynamic_loading/1']"))).click();

        WebElement startBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Start']")));
        Thread.sleep(3000);
        if(startBtn.isDisplayed()){
            System.out.println("Pass: Start Button is Displayed");
        }else{
            System.out.println("Fail: Start Button Mismatch");
        }
        startBtn.click();
        Thread.sleep(3000);

        WebElement displayMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        String message= displayMessage.getText();
        Thread.sleep(3000);
        if(message.equals("Hello World!")){
            System.out.println("Pass: Message Handled correctly");
        }else {
            System.out.println("Fail: Message Mismatched");
        }
        driver.quit();
    }
}
