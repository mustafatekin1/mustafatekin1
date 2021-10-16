package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Day08_TestBaseDemo extends TestBase {
/*
Test 1 : go to  `https://www.google.com`
        search porcelain teapot
        Assert if results contain porcelain teapot

Test 2: same task with https://www.amazon.com
 */


    @Test
    public void test() {
        driver.get("https://www.google.com"); // driver variable must be either protected or public
        // in the testbase class in utilities to remove red error.
        driver.findElement(By.name("q")).sendKeys("porcelain teapot" + Keys.RETURN);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("porcelain teapot"+Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }


}
