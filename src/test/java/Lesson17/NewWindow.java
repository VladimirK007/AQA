package Lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewWindow {

    public WebDriver driver;
    public String baseUrl = "https://demoqa.com/browser-windows";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void openNewWindow() {
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
        driver.quit();

    }

}
