package Lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task4 {

    @Test

    public void removeAccounts() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//button[normalize-space()='Delete']"));
        for (WebElement ignored : elements) {
            driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
        }

        // driver.quit();
    }

}
