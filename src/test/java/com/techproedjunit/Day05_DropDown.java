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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day05_DropDown {
    /*
    Interview question
    We can locate from dropdown with 3 ways
and also there are 3 steps we have to execute to locate any dropdown element:
    selectByIndex(), selectByValue(), selectByVisibleText()
   ***  and all dropdown in a list with getOptions()

    3 steps are as following:
    1. Locate the select element
    2. Create select obj from Select class
    3. Locate the desired dropdown item via 3 diff ways mentioned above


Task checkbox:
-go to http://the-internet.herokuapp.com/dropdown
- Create 3 test methods to locate dropdown items with 3 ways
    selectByIndex(), selectByValue(), selectByVisibleText()
- Print all dropdown items in a list
- print first selected optiion via method
- find the size of the dropdown

 */
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void selectByIndexTest(){

        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);// selects Option 1 from the dropdown ==> count from zero
    }

    @Test
    public void selectByValue() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByValue("2");

        System.out.println(select.getOptions());
    }

    @Test
    public void selectByVisibleText() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

        Thread.sleep(3000);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Option 2");
    }

    @Test
    public void printDropDownAsList () {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownList = select.getOptions();
        for ( WebElement w:dropdownList) {
           // System.out.println(w);// This gives the hashcode
            System.out.println(w.getText());// This gives the text
        }

    }


    @Test
    public void printFirstSelectedOption (){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        WebElement first = select.getFirstSelectedOption();
        System.out.println(first.getText());
        Assert.assertTrue(first.getText().equals("Please select an option"));
    }

    @Test
    public void getSizeOfDropDown (){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownList = select.getOptions();

        int sizeOf = dropdownList.size();
        System.out.println(sizeOf);
        Assert.assertEquals(3, sizeOf);


    }

    @After
    public void teardown() throws InterruptedException {
       Thread.sleep(3000);
        driver.close();

    }



}
