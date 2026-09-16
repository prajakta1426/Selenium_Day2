package DrivingLicenseApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class TestDrivingLicenseAppWelcomePage {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try{

            webDriver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(1000);

            //original window handle
            String parentWindow = webDriver.getWindowHandle();

            WebElement licenseType = webDriver.findElement(By.id("licenseType"));
            Select licensetypeSelect = new Select(licenseType);
            licensetypeSelect.selectByVisibleText("Permanent");
            licensetypeSelect.selectByIndex(1);
            licensetypeSelect.selectByValue("permanent");
            Thread.sleep(1000);

            WebElement fullname= webDriver.findElement(By.id("fullname"));
            fullname.sendKeys("Harry");
            Thread.sleep(1000);

            WebElement address=webDriver.findElement(By.xpath("//input[@id='address']"));
            address.sendKeys("Pune");
            Thread.sleep(1000);


            WebElement age = webDriver.findElement(By.cssSelector("#age"));
            age.sendKeys("25");
            Thread.sleep(1000);


            WebElement placeofBirth = webDriver.findElement(By.cssSelector("#placeofbirth"));
            placeofBirth.sendKeys("Pune");
            Thread.sleep(1000);


            WebElement gender=webDriver.findElement(By.id("Male"));
            gender.click();
            Thread.sleep(1000);

            WebElement colorblindness=webDriver.findElement(By.xpath("//label/input[@name='color_yes']"));
            colorblindness.click();
            Thread.sleep(500);

            WebElement languages= webDriver.findElement(By.cssSelector("#languages"));
            Select languagesSelect=new Select(languages);
            languagesSelect.selectByValue("english");
            languagesSelect.selectByIndex(3);
            languagesSelect.selectByVisibleText("Marathi");
            Thread.sleep(1000);

            WebElement submit= webDriver.findElement(By.cssSelector("form#myForm > button"));
            submit.click();
            Thread.sleep(5000);

            //get all window handles
            Set<String> allWindowHandles = webDriver.getWindowHandles();
            String newWindow = null;

            for(String window : allWindowHandles)
            {
                System.out.println("Window handle description : "+window);

                if(!window.equals(parentWindow))
                {
                    webDriver.switchTo().window(window);
                    newWindow = webDriver.getWindowHandle();
                    System.out.println("Window handle description : "+window);
                }
            }

            String actualURL = webDriver.getCurrentUrl();
            if (actualURL.contains("welcome.html"))
                System.out.println("PASS : URL Verified "+actualURL);
            else
                System.out.println("FAIL : URL mismatch "+actualURL);

            String actualTitle = webDriver.getTitle();
            if (actualTitle.equals("Welcome"))
                System.out.println("PASS : Welcome page is displayed");
            else
                System.out.println("FAIL : Welcome page is not displayed");


            WebElement nameField= webDriver.findElement(By.id("nameField"));
            if(!nameField.isEnabled()){
                System.out.println("PASS : Name Field is disabled");
            }
            else{
                System.out.println("FAIL : Name Field is active");
            }
            WebElement enterNameBtn= webDriver.findElement(By.id("enterNameBtn"));
            enterNameBtn.click();
            if(nameField.isEnabled()){
                System.out.println("PASS : Name Field is active after clicking Enter Name button");
                nameField.sendKeys("abcd");
                System.out.println("PASS : Name field can be populated");
            }
            else{
                System.out.println("FAIL : Name Field is disabled after clicking Enter Name button");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            webDriver.quit();
        }
    }
}
