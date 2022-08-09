package Lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 {

    @Test

    public void addCustomer() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[contains(.,'Add Customer')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ben");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Yellow");
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();

        driver.quit();
    }

}
