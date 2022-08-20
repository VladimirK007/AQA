package Lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewWindow {

    public WebDriver driver;
    public String baseUrl = "https://www.toolsqa.com/automation-practice-switch-windows/";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);

    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
        driver.quit();

    }

}
