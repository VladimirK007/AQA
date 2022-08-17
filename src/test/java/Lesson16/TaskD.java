package Lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskD {
    @Test

    public void addToCartAmazon() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.findElement(By.xpath("//span[@id='glow-ingress-line2']")).click();

        WebElement zipInput;
        zipInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='GLUXZipUpdateInput']")));
        zipInput.sendKeys("10001");


        driver.findElement(By.xpath("//input[@aria-labelledby='GLUXZipUpdate-announce']")).click();

        WebElement continueButton;
        continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//DIV[@id='GLUXHiddenSuccessSubTextAisEgress']/../../..//INPUT[@id='GLUXConfirmClose'])[2]")));
        continueButton.click();

        WebElement todaysDeals;
        todaysDeals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//A[@href='/deals?ref_=nav_cs_gb']")));
        todaysDeals.click();

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[21]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/span[1]/div[1]/div[1]/a[1]/div[1]")).click();
        driver.findElement(By.xpath("//span[@class='a-dropdown-prompt'][normalize-space()='Select']")).click();


        WebElement sizeS;
        sizeS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='native_dropdown_selected_size_name_1']")));
        sizeS.click();

        WebElement inStock;
        inStock = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-size-medium a-color-success']")));
        inStock.isDisplayed();

        WebElement addToCartBtn;
        addToCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
        addToCartBtn.click();

        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();

    }
}
