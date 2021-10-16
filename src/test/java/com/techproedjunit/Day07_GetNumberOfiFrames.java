package com.techproedjunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_GetNumberOfiFrames {
/*
go to https://www.amazon.com
find the number of iframes in the Landing Page

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
    public void getNumberOfiFrames() {

    List<WebElement> iFramesList = driver.findElements(By.tagName("iframe"));
    int numberOfIframes = iFramesList.size();
    System.out.println(numberOfIframes);
    //or
    System.out.println(driver.findElements(By.xpath("//iframe")).size());

    }

@After
    public void teardown(){
    driver.close();
}
}
