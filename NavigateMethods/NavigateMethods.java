package NavigateMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.manage().window().maximize();
            webDriver.get("https://github.com");
            System.out.println("Git Hub window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());
            Thread.sleep(3000);

            webDriver.navigate().to("https://www.google.com");
            System.out.println("Google window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());
            Thread.sleep(3000);

            webDriver.navigate().to("https://www.saucedemo.com");
            System.out.println("Sauce demo window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());
            Thread.sleep(3000);

            webDriver.navigate().back();
            System.out.println("Google window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());
            Thread.sleep(3000);

            webDriver.navigate().back();
            System.out.println("Git Hub window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());
            Thread.sleep(3000);

            webDriver.navigate().forward();
            System.out.println("Google window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());
            Thread.sleep(3000);

            webDriver.navigate().refresh();
            System.out.println("Google window handle : "+webDriver.getWindowHandle());
            System.out.println("Window Title : " +webDriver.getTitle());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            webDriver.quit();
        }
    }
}
