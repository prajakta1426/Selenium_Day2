package WaitClassTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class WelcomePageImplicitWait {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        //implicit wait
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try{

            webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(2000);

            WebElement licenseType = webDriver.findElement(By.id("licenseType"));
            Select licensetypeSelect = new Select(licenseType);
            licensetypeSelect.selectByVisibleText("Permanent");
            licensetypeSelect.selectByIndex(1);
            licensetypeSelect.selectByValue("permanent");

            WebElement fullname= webDriver.findElement(By.id("fullname"));
            fullname.sendKeys("Harry");

            WebElement address=webDriver.findElement(By.xpath("//input[@id='address']"));
            address.sendKeys("Pune");


            WebElement age = webDriver.findElement(By.cssSelector("#age"));
            age.sendKeys("25");


            WebElement placeofBirth = webDriver.findElement(By.cssSelector("#placeofbirth"));
            placeofBirth.sendKeys("Pune");


            WebElement gender=webDriver.findElement(By.id("Male"));
            gender.click();

            WebElement colorblindness=webDriver.findElement(By.xpath("//label/input[@name='color_yes']"));
            colorblindness.click();

            WebElement languages= webDriver.findElement(By.cssSelector("#languages"));
            Select languagesSelect=new Select(languages);
            languagesSelect.selectByValue("english");
            languagesSelect.selectByIndex(3);
            languagesSelect.selectByVisibleText("Marathi");

            WebElement submit= webDriver.findElement(By.cssSelector("form#myForm > button"));
            submit.click();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            webDriver.quit();
        }
    }
}
