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


public class WaitForVisibiliyty {

    public WebDriver driver;
    public String baseUrl = "https://demoqa.com/dynamic-properties";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void waitForVisibility(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement visibleAfter5SecondsButton;
        visibleAfter5SecondsButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        visibleAfter5SecondsButton.isDisplayed();

    }

    @AfterTest
    public void terminateBrowser() {

        driver.quit();

    }


}
