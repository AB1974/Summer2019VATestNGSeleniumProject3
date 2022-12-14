package com.cybertek.tests.tryout;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {

    WebDriver driver=null;
    @Parameters({"browserName"})
    @BeforeTest
    public void setup(String browserName) throws InterruptedException {

        System.out.println("Browser name is: "+browserName+Thread.currentThread().getId());
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }

        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        else if (browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        }

    }




    @Test
    public void test1() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(4000);
        System.out.println("Test 1 passed");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(4000);
        System.out.println("Test 2 passed");
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(4000);
        System.out.println("Test 3 passed");
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
