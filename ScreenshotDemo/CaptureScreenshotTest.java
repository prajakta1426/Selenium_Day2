package ScreenshotDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.util.Set;

public class CaptureScreenshotTest {
    static WebDriver driver;
    static String screenshotDir;
    public static void main(String[] args) {
        screenshotDir = "screenshots/";
        new File(screenshotDir).mkdirs();
        try {
            driver = new ChromeDriver();
            driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(2000);

            String actualTitle = driver.getTitle();
            String expectedTitle = "Driving License Application....";

            if(actualTitle.equals(expectedTitle))
                System.out.println("PASS : Title verified. Actual Title "+actualTitle);
            else {
                System.out.println("FAIL : Title MISMATCH. Actual Title " + actualTitle);
                captureScreenshot(driver,"FAIL_title_mismatch");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }
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
