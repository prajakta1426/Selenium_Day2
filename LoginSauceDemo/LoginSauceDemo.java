package LoginSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSauceDemo {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try
        {
            webDriver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);


            WebElement username = webDriver.findElement(By.id("user-name"));
            WebElement password = webDriver.findElement(By.id("password"));
            WebElement submitButton = webDriver.findElement(By.id("login-button"));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            Thread.sleep(2000);

            submitButton.click();

            Thread.sleep(2000);

            if(webDriver.getCurrentUrl().contains("inventory.html"))
            {
                System.out.println("Login successful");
            }
            else
            {
                System.out.println("Login failed");
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
