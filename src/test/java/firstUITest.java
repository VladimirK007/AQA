import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class firstUITest {

@Test

    public void loginInChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\AQA\\target\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.i.ua/");
        driver.findElement(By.name("login")).sendKeys("aqa_tests");
        driver.findElement(By.name("pass")).sendKeys("Asd123op");
        driver.findElement(By.xpath("//SELECT[@name='domn']/../../../..//INPUT[@type='submit']")).click();
        driver.quit();
    }

    @Test

    public void loginInFirefoxWithManager() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.i.ua/");
        driver.findElement(By.name("login")).sendKeys("aqa_tests");
        driver.findElement(By.name("pass")).sendKeys("Asd123op");
        driver.findElement(By.xpath("//SELECT[@name='domn']/../../../..//INPUT[@type='submit']")).click();
        driver.quit();
    }
}
