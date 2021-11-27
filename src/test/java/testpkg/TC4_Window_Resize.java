package testpkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author Panagiotis Drakos
 * Student Id: L00170565
 * Selenium Testing
 */

public class TC4_Window_Resize {

    private WebDriver driver;


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

        // Method 2 for web driver for Chrome browser is the one shown below
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to guru99 demo page from the new object created above with WebDriver
        driver.get("http://demo.guru99.com/test/newtours/index.php");

        //driver.manage().window().getSize().getHeight(); // Get the Height of the window
        //driver.manage().window().getSize().getWidth(); // Get the Width of the window

        Dimension size = driver.manage().window().getSize(); // store dimensions
        System.out.println(size.getHeight()); // Print the Height of the window to console
        System.out.println(size.getWidth()); // Print the Width of the window to console

        // Set new size dimensions to the window
        driver.manage().window().setSize(new Dimension(1095,881));

        Thread.sleep(2000); // Wait statements for demo purposes. Throws Exception in main function
    }

}
