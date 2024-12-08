package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExtentTestManager;
import utils.Log;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        Log.info("Setting up the ChromeDriver");
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateUrl() {
        ExtentTestManager.startTest("Validate Login", "Verify login functionality of the dummy site");

        Log.info("Navigating to the login page");
        driver.get("https://baazigames.com/");
        Log.info("Locating and interacting with web elements");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='navbarNav']/span[3]/a")));
        contactUs.click();

        Log.info("Validating URL");
        String expectedUrl = "https://baazigames.com/contact-us/index.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or URL mismatch");
        driver.get("https://baazigames.com/");

        ExtentTestManager.endTest();
    }

    @AfterClass
    public void tearDown() {
        Log.info("Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
