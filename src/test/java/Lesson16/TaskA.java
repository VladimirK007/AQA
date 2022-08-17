package Lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskA {

    @Test

    public void addBookToCollection() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");


        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Vtest77");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test@123");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement goToStoreBtn;
        goToStoreBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gotoStore\"]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", goToStoreBtn);

        goToStoreBtn.click();

        WebElement bookButton;
        bookButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")));

        bookButton.click();

        WebElement addNewRecordBtn;

        js.executeScript("window.scrollBy(0,250)", "");
        addNewRecordBtn = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")));

        addNewRecordBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Book"));
        alert.accept();

        WebElement backToBookStore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[1]/button")));

        backToBookStore.click();

        WebElement book2Button;
        js.executeScript("window.scrollBy(0,250)", "");
        book2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"see-book-You Don't Know JS\"]/a")));

        book2Button.click();

        js.executeScript("window.scrollBy(0,250)", "");
        addNewRecordBtn = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")));

        addNewRecordBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains("Book"));
        alert.accept();

        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();

        js.executeScript("window.scrollBy(0,250)", "");

        WebElement deleteAllbtn;
        deleteAllbtn = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"submit\"][text()='Delete All Books']")));
        deleteAllbtn.click();

        WebElement okButton;
        okButton = wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='closeSmallModal-ok']"))));
        okButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        Assert.assertTrue(alert2.getText().contains("All Books deleted"));
        alert2.accept();

        driver.quit();

    }
}