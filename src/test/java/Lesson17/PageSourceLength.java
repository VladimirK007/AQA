package Lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageSourceLength {

    public WebDriver driver;
    public String baseUrl = "https://shop.demoqa.com/";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void getMethods() {
        System.out.println();
        String pageTitle = driver.getTitle();
        System.out.println("Page Title name: " + pageTitle);

        int titleLength = (pageTitle.length());
        System.out.println("Title length: " + titleLength);

        String pageURL = driver.getCurrentUrl();
        System.out.println("Page URL: " + pageURL);

        String expectedPageURL = "https://shop.demoqa.com/";

        Assert.assertEquals(expectedPageURL, pageURL);

        String pageSource = driver.getPageSource();
        int pageSourceLength = (pageSource.length());
        System.out.println("Page Source Length: " + pageSourceLength);

    }

    @AfterTest
    public void terminateBrowser() {
        driver.quit();

    }

}


