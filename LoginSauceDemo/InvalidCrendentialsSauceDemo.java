package LoginSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidCrendentialsSauceDemo {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try
        {
            webDriver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            //getting web elements
            WebElement username = webDriver.findElement(By.id("user-name"));
            WebElement password = webDriver.findElement(By.id("password"));
            WebElement submitButton = webDriver.findElement(By.id("login-button"));

            //invalid inputs
            username.sendKeys("abc");
            password.sendKeys("abc123");
            Thread.sleep(2000);

            submitButton.click();

            Thread.sleep(2000);

            WebElement errorButton= webDriver.findElement(By.className("error-button"));
            //checks if error message is displayed
            System.out.println("Error message is displayed : "+errorButton.isDisplayed());

            WebElement error= webDriver.findElement(By.xpath("//h3[@data-test='error']"));
            String errormessage = "Epic sadface: Username and password do not match any user in this service";
            //check the text present in error message
            if(error.getText().equals(errormessage))
            {
                System.out.println("The error message for invalid inputs is displayed");
            }
            else
            {
                System.out.println("Error message not displayed");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            //to close the chrome driver/ browser
            webDriver.quit();
        }
    }
}
