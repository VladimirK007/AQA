package Lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task4 {

    public WebDriver driver;
    public String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void removeAccounts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//button[normalize-space()='Delete']"));
        for (WebElement ignored : elements) {
            driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
        }

    }

    @AfterTest
    public void terminateBrowser() {
        driver.quit();
    }
}
