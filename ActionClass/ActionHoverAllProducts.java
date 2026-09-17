package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionHoverAllProducts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/CCST/Desktop/SeleniumMaterial/actionClass_Menu.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        WebElement obj_menuItem = driver.findElement(By.id("productsMenu"));
        action.moveToElement(obj_menuItem).perform();

        WebElement obj_SubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productsSubmenu")));
        if(obj_SubMenu.isDisplayed())
            System.out.println("PASS : Submenu has appeared on hover");
        else
            System.out.println("FAIL : Submenu has NOT appeared on hover");

        action.moveToElement(obj_menuItem).perform();

        //to verify click on Laptops link
        WebElement obj_LaptopsLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("laptopsLink")));
        obj_LaptopsLink.click();

        String result = "You clicked: Laptops";
        String obj_Result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))).getText();
        if(result.equals(obj_Result))
            System.out.println("PASS : Clicked Laptops");
        else
            System.out.println("FAIL : Result mismatch. Actual : "+obj_Result);

        //to verify click on Phones link
        WebElement obj_phonesLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("phonesLink")));
        obj_phonesLink.click();

        String result1 = "You clicked: Phones";
        String obj_Result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))).getText();
        if(result1.equals(obj_Result1))
            System.out.println("PASS : Clicked Phones");
        else
            System.out.println("FAIL : Result mismatch. Actual : "+obj_Result1);

        //to verify click on Laptops link
        WebElement obj_tabletsLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("tabletsLink")));
        obj_tabletsLink.click();

        String result2 = "You clicked: Tablets";
        String obj_Result2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))).getText();
        if(result2.equals(obj_Result2))
            System.out.println("PASS : Clicked Tablets");
        else
            System.out.println("FAIL : Result mismatch. Actual : "+obj_Result2);

        driver.quit();
    }
}
