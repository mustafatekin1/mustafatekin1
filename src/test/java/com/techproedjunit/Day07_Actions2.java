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

public class Day07_Actions2 {
    /*
 Create a hoverOverTest () method
 Go to Amazon home page: https://www.amazon.com
 Click on Account link
 Then verify the title contains "Your Account"

  */
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @Test
    public void hoverOverTest () throws InterruptedException {
       WebElement signinHoverElement =  driver.findElement(By.id("nav-link-accountList"));
       Actions actions = new Actions(driver);
       actions.moveToElement(signinHoverElement).perform();
       Thread.sleep(5000);

       driver.findElement(By.xpath("//span[.='Account']")).click();
        String accountTitle = driver.getTitle();
        Assert.assertTrue(accountTitle.contains("Your Account"));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
