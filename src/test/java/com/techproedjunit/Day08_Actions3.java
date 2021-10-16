package com.techproedjunit;

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

public class Day08_Actions3 {
    /*
    task: create keysUpDown() method
    - go to https://www.google.com
    - send iphone x prices,  send lowercase --> uppercase and vice a versa
    - Highligh the search box by double clicking
  */

    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

    }
    @Test
    public void keysUpDown() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));

        //searchBox.sendKeys("iPhone X prices");
        Actions actions = new Actions(driver);
        // Lets make the entered keys uppercase with keys down on shift
        actions.keyDown(searchBox, Keys.SHIFT)
                .sendKeys("iPhone X prices")
                .keyUp(searchBox, Keys.SHIFT)
                .sendKeys(" too expensive"+Keys.ENTER)
                .perform();


    }

    @After
    public void teardown(){
        driver.quit();
    }

}
