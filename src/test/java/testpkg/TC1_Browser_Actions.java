package testpkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * @author Panagiotis Drakos
 * Student Id: L00170565
 * Selenium Testing
 */

public class TC1_Browser_Actions {

    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

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

        // Get to www.google.com first. Both get and navigate do the same action
        driver.get("https://www.google.com");
        String mainWindow = driver.getWindowHandle(); // Manage windows in browser

        // Navigate to guru99 demo page from the new object created above with WebDriver
        //driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
        driver.manage().window().setSize(new Dimension(1536, 901));
        driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");

        System.out.print(driver.getCurrentUrl()); // For Lab Demo purposes printing in terminal the URL
        System.out.print(driver.getTitle()); // For Lab Demo purposes printing in terminal the Titles

        driver.navigate().back();
        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function
        driver.navigate().forward();
        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function
        driver.navigate().refresh();

        driver.switchTo().newWindow(WindowType.TAB); // Open a new Tab in current window
        driver.switchTo().window(mainWindow); // Switch to mainWindow

        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function
    }
}
