package Lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 {

    public WebDriver driver;
    public String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void addCustomer() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[contains(.,'Add Customer')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Robert");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Pique");
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();

    }

    @AfterTest
    public void terminateBrowser() {
        driver.quit();

    }

}
