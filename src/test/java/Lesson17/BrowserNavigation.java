package Lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserNavigation {

    public WebDriver driver;
    public String baseUrl = "https://demoqa.com/";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void browserNavigate() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement registrationButton;

        registrationButton = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//img[@alt='Selenium Online Training']")));
        registrationButton.click();

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(baseUrl);
        driver.navigate().refresh();

    }

    @AfterTest
    public void terminateBrowser() {

        driver.quit();

    }

}
