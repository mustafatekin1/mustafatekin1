package com.techproedjunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day07_Actions1 {
    /*
    The task is :
go to "https://the-internet.herokuapp.com/context_menu"

 We have Actions class in Selenium.
 we create an object from that class and there are many useful methods to use as mouse and keyboard actions
 4 steps:
 -1. Create action object
 -2. Locate the WebElement
 -3. enter the action method.
 -4. type perform() so that perfrom the entered action in step 3

  */


    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void contextClickMethod() throws InterruptedException {
        /* contextClick() = right click
        go to "https://the-internet.herokuapp.com/context_menu"
        right click on the box
        Verify the message "You selected a context menu"
        Click Ok for the alert.
        */
        // right click on the box
        Actions action1 = new Actions(driver);
        WebElement boxElement = driver.findElement(By.cssSelector("#hot-spot"));
        action1.contextClick(boxElement).perform();

        String alert1 = driver.switchTo().alert().getText();
        String expectedAlert = "You selected a context menu";
        System.out.println(alert1);
        Assert.assertEquals(expectedAlert, alert1);

        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @After
    public void teardown(){
        driver.quit();
    }



}
