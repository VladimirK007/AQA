package Lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task3 {

    public WebDriver driver;
    public String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeTest

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test

    public void newAccount() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();

        driver.findElement(By.xpath("//select[@id='userSelect']")).click();
        driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[text()='Hermoine Granger']")).click();

        driver.findElement(By.xpath("  //select[@id='currency']")).click();
        driver.findElement(By.xpath("//*[@id=\"currency\"]/option[text()='Rupee']")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Process']")).click();

        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();



    }

    @AfterTest
    public void terminateBrowser() {
        driver.quit();

    }

}
