package com.techproedjunit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

// The task is search for 'teapot porcelain' then print the number of the results
public class Day04_Xpath_Search {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    // This IMPLICIT wait means wait 30 secs "WHEN NEEDED" OTHERWISE PROCEED
    // IMPLICIT wait is coming from selenium unlike Thread.sleep
    // When we just use once it is enough for the driver to wait anytime required.
    /* WHY WAIT IS NEEDED?
        - The website maybe slow due to videos, images etc
        - The internet or local computer is slow
        - The staging websites may be slow
      */
    driver.manage().window().maximize();

    }
@After
public void teardown () throws InterruptedException {
  Thread.sleep(2000);
   driver.close();

}
    @Test
    public void teaPotSearch (){
        driver.get("https://www.google.com");
//my solution is to locate the "Google'da Ara" and click on it
//driver.findElement(By.xpath("//input[contains(@class, 'gL')]")).sendKeys("porcelain teapot");
//driver.findElement(By.xpath("(//input[contains(@value, 'Google')])[2]")).click();

    //teacher's solution
        driver.findElement(By.xpath("//input[@name='q']")).
                sendKeys("porcelain teapot" + Keys.ENTER);

String results = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
// I use id in xpath to exercise

        System.out.println(results);
// My solution
        String split [] = results.split(" ");
        System.out.println(Arrays.toString(split));
        System.out.println(split[1]);

        String split1 = split[1];
       // int number = Integer.parseInt(split1);
       // System.out.println("The number of results is " + number);

// Teacher's solution:
        String numberSubstring = results.substring(9, 19);
        // This is faster but when the number of the results change, this causes a problem
        System.out.println("The result from the second code:" + numberSubstring);

    }




}
