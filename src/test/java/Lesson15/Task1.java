package Lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.time.Duration;


public class Task1 {

    @Test

    public void makeDepositWithdrawal() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
        driver.findElement(By.xpath("//select[@id='userSelect']")).click();
        driver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[text()='Hermoine Granger']")).click();
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("900");
        driver.findElement(By.xpath("//button[text()='Withdraw']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();

        driver.quit();
    }
}
