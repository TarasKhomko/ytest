package firefoxScripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by taras on 11.12.2016.
 */
public class YawareDownloadTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //Firefox
        // System.setProperty("webdriver.gecko.driver", "C:\\server\\geckodriver.exe");
        //  driver = new FirefoxDriver();
        //Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\server\\chromedriver.exe");
        driver = new ChromeDriver();
        //Opera
        //  System.setProperty("webdriver.opera.driver", "C:\\server\\operadriver.exe");
        //  driver = new OperaDriver();
        baseUrl = "http://app.yaware.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testYaware3() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("taras.khomko@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("TKh1391");
        driver.findElement(By.cssSelector("#login-submit > span")).click();
        driver.findElement(By.linkText("Dashboard")).click();
        driver.findElement(By.id("welcome-add-employees")).click();
        driver.findElement(By.id("welcome-download-client")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
