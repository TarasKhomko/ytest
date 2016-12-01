package firefoxScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by taras on 29.11.2016.
 */
public class MyFirstTestCase {
    public static void main (String[] args){
        System.setProperty("webdriver.gecko.driver", "C:\\server\\geckodriver.exe");
        // System.setProperty("webdriver.chrome.driver", "C:\\server\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //  WebDriver driver = new ChromeDriver();
        driver.get("http://app.yaware.com/");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("taras.khomko@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("TKh1391");
        driver.findElement(By.id("login-submit")).click();
    }
}
