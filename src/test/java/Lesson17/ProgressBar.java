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

public class ProgressBar {

    public WebDriver driver;
    public String baseUrl = "https://demoqa.com/progress-bar";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test
    public void progressBar() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(By.xpath("//button[@id='startStopButton']")).click();

        WebElement resetButton;
        resetButton = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//button[@id='resetButton']")));
        resetButton.click();

        WebElement startButton;
        startButton = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//button[@id='startStopButton']")));
        startButton.isDisplayed();
    }

    @AfterTest
    public void terminateBrowser() {

        driver.quit();

    }

}
