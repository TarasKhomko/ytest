package firefoxScripts;

/**
 * Created by taras on 09.12.2016.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class YawareCreateTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //Firefox
      //  System.setProperty("webdriver.gecko.driver", "C:\\server\\geckodriver.exe");
     //   driver = new FirefoxDriver();
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
    public void testYawareCreate() throws Exception {
        int a = (int) (Math.random() * (20000 + 2)) - 10000;
        a = Math.abs(a);
        String s = String.valueOf(a);
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a[contains(@href, '#register')]")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Taras");
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Test");
        driver.findElement(By.id("registerEmail")).clear();
        driver.findElement(By.id("registerEmail")).sendKeys(s+".taras@gmail.com");
        driver.findElement(By.id("pwd1")).clear();
        driver.findElement(By.id("pwd1")).sendKeys("KhT1391");
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("+380 96 000 "+s);
        driver.findElement(By.cssSelector("#register-account-submit > span")).click();
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