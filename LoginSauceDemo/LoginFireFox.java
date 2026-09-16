package LoginSauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFireFox {
    public static void main(String[] args) {

        WebDriver webDriver = new FirefoxDriver();
        try
        {
            webDriver.get("https://www.saucedemo.com/");

            Thread.sleep(2000);
//            WebElement title = webDriver.findElement(By.className("login_logo"));
//            System.out.println(title.getText());
            System.out.println(webDriver.getTitle());

            webDriver.get("https://google.com");
//            WebElement  title1 = webDriver.findElement(By.className("ESTs9d"));
//            System.out.println(title1.getAttribute("aria-label"));
            System.out.println(webDriver.getTitle());
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
