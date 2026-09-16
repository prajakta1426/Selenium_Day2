package ScreenshotDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class IFrameScreenShot {
    static String screenshotDir;
    public static void main(String[] args) throws InterruptedException {
        screenshotDir = "screenshots/";
        new File(screenshotDir).mkdirs();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/iFrameDemo.html");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        //frame 1 by index
        driver.switchTo().frame(0);
        WebElement fram1Btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("frame1Btn")));
        fram1Btn.click();
        Thread.sleep(2000);

        String frameResult=driver.findElement(By.id("frame1Result")).getText();
        if(frameResult.equals("Frame 1 button clicked!..."))
            System.out.println("PASS : Frame 1 handle correctly");
        else {
            System.out.println("FAIL : Frame 1 result mismatch");
            captureScreenshot(driver,"Frame1_mismatch");
        }
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //frame 2 by name
        driver.switchTo().frame("frameByName");
        WebElement frame2Input = wait.until(ExpectedConditions.elementToBeClickable(By.id("frame2Input")));
        frame2Input.sendKeys("Selenium Student");

        String enteredValue = frame2Input.getAttribute("value");
        if(enteredValue.equals("Selenium Student..."))
            System.out.println("PASS : Frame 2 handle correctly");
        else {
            System.out.println("FAIL : Frame 2 result mismatch");
            captureScreenshot(driver,"Frame2_mismatch");
        }
        Thread.sleep(2000);

        driver.switchTo().parentFrame();

        //frame 3 by WebElement
        WebElement frame3Element =driver.findElement(By.id("frame3"));
        driver.switchTo().frame(frame3Element);

        WebElement dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame3Dropdown")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");
        String selectvalue= select.getFirstSelectedOption().getText();
        if(selectvalue.equals("Two...")){
            System.out.println("PASS : frame 3 handled correctly ");
        }
        else{
            System.out.println("FAIL : Frame 3 result mismatch");
            captureScreenshot(driver,"Frame3_mismatch");
        }
        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        //frame 4: nested frames
        WebElement frame4Element =driver.findElement(By.id("outerFrame"));
        driver.switchTo().frame(frame4Element);
        System.out.println("In outer Frame");
        WebElement innerFrame =driver.findElement(By.id("innerFrame"));
        driver.switchTo().frame(innerFrame);
        System.out.println("In inner Frame");
        WebElement innerFrameBtn = driver.findElement(By.id("innerFrameBtn"));
        innerFrameBtn.click();
        Thread.sleep(2000);

        String innerFrameResult=driver.findElement(By.id("innerFrameResult")).getText();
        if(innerFrameResult.equals("Inner frame button clicked!"))
            System.out.println("PASS : Frame 4 handle correctly");
        else {
            System.out.println("FAIL : Frame 4 result mismatch");
            captureScreenshot(driver,"Frame4_mismatch");
        }
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        WebElement mainbutton = driver.findElement(By.id("mainBtn"));
        if(mainbutton.isDisplayed()){
            System.out.println("Successfully return to main page");
        }
        driver.quit();

    }
    public static void captureScreenshot(WebDriver driver, String file_name)
    {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotDir + "/"+file_name+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
