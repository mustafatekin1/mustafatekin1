package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions4 extends TestBase {
    /*
    task: create scrollUpDown() method
    - go to https://www.amazon.com
    -
  */
        // i comment out the following codes because I extend this class to TestBase class in utilities.
//    WebDriver driver;
//    @Before
//    public void start(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform(); // scrolls about a page like page-down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); // little scroll like down-arrow
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }

//    @After
//    public void teardown(){
//        driver.quit();
//    }

}
