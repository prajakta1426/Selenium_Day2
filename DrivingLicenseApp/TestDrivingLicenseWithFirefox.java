package DrivingLicenseApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDrivingLicenseWithFirefox {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        try{

            webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(2000);

            WebElement licenseType = webDriver.findElement(By.id("licenseType"));
            licenseType.sendKeys("Learning");
            Thread.sleep(1000);

            WebElement fullname= webDriver.findElement(By.id("fullname"));
            fullname.sendKeys("Nova");
            Thread.sleep(1000);

            WebElement address=webDriver.findElement(By.xpath("//input[@id='address']"));
            address.sendKeys("Pune");
            Thread.sleep(1000);


            WebElement age = webDriver.findElement(By.cssSelector("#age"));
            age.sendKeys("25");
            Thread.sleep(1000);


            WebElement placeofBirth = webDriver.findElement(By.cssSelector("#placeofbirth"));
            placeofBirth.sendKeys("Beijing");
            Thread.sleep(1000);


            WebElement gender=webDriver.findElement(By.id("Female"));
            gender.click();
            Thread.sleep(1000);

            WebElement colorblindness=webDriver.findElement(By.xpath("//label/input[@name='color_no']"));
            colorblindness.click();
            Thread.sleep(500);

            WebElement languages= webDriver.findElement(By.cssSelector("#languages > option[value='japanese']"));
            languages.click();
            Thread.sleep(1000);

            WebElement submit= webDriver.findElement(By.cssSelector("form#myForm > button"));
            submit.click();
            Thread.sleep(1000);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            webDriver.quit();
        }
    }
}
