package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExtentTestManager;
import utils.Log;

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
    public void validateLogin() {
        ExtentTestManager.startTest("Validate Login", "Verify login functionality of the dummy site");

        Log.info("Navigating to the login page");
        driver.get("https://example.com/login");
        Log.info("Locating and interacting with web elements");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        Log.info("Entering credentials");
        username.sendKeys("testuser");
        password.sendKeys("testpassword");

        Log.info("Clicking the login button");
        loginButton.click();

        Log.info("Validating successful login");
        String expectedUrl = "https://example.com/home";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or URL mismatch");

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
