package com.techproedjunit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_CheckBox {
/*
Task checkbox:
-go to http://the-internet.herokuapp.com/checkboxes
-locate the elements of checkboxes
-click checkbox1 if it is not selected
-click checkbox2 if it is not selected
-: verify checkboxes are checked.


 */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkbox() {
    driver.get("http://the-internet.herokuapp.com/checkboxes");

    WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

    if (!checkbox1.isSelected()) {
        checkbox1.click();
    }
    if (!checkbox2.isSelected()){
        checkbox2.click();
    }
    Assert.assertTrue(checkbox1.isSelected());
    Assert.assertTrue(checkbox2.isSelected());

    }
    @After
    public void finish(){
    driver.close();

    }

}
