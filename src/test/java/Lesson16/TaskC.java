package Lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class TaskC {

    @Test

    public void addToDo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys("MAKE HOMEWORK");
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(ENTER);

        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys("Practice Automation");
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(ENTER);

        driver.findElement(By.xpath("//li[normalize-space()='Practice magic']")).click();

        WebElement trashButton = driver.findElement(By.xpath("//li[normalize-space()='Buy new robes']"));

        Actions action = new Actions(driver);

        action.moveToElement(trashButton).perform();

        driver.findElement(By.xpath("//li[normalize-space()='Buy new robes']//i[@class='fa fa-trash']")).click();


    }
}
