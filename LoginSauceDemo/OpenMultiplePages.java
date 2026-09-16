package LoginSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenMultiplePages {

    public static void main(String[] args) {


        WebDriver webDriver = new ChromeDriver();
        try
        {
            webDriver.get("https://www.saucedemo.com/");

            Thread.sleep(2000);
            WebElement title = webDriver.findElement(By.className("login_logo"));
            System.out.println(title.getText());

            webDriver.get("https://google.com");
            WebElement  title1 = webDriver.findElement(By.className("ESTs9d"));
            System.out.println(title1.getAttribute("aria-label"));
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
