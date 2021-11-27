package testpkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

/**
 * @author Panagiotis Drakos
 * Student Id: L00170565
 * Selenium Testing
 */

public class TC3_Register_New_User {
    private WebDriver driver;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
    @Test
    public void first_case() throws InterruptedException {
        // Manage Web Browser timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("http://demo.guru99.com/test/newtours/index.php");
        driver.switchTo().newWindow(WindowType.TAB); // Open a new Tab in current window
        driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");

        // Provide input for the following items to register a new user
        driver.findElement(By.name("firstName")).sendKeys("Jack");
        driver.findElement(By.name("lastName")).sendKeys("Jones");
        driver.findElement(By.name("phone")).sendKeys("+30 6947552114");

        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement dropdown = driver.findElement(By.name("country"));
        dropdown.findElement(By.xpath("//option[. = 'GREECE']")).click();

        WebElement element = driver.findElement(By.name("country"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().perform();

        // Attribute for box "username" is located in box "e-mail"
        driver.findElement(By.name("userName")).sendKeys("Jack_Jones");
        driver.findElement(By.name("password")).sendKeys("Jones123!");
        driver.findElement(By.name("confirmPassword")).sendKeys("Jones123!");
        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function

        WebElement button = driver.findElement(By.name("submit"));
        js.executeScript("arguments[0].click();", button); // Execute the Submit button for new registration

        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function
    }
}
