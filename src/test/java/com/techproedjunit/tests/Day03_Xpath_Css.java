package com.techproedjunit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day03_Xpath_Css {
    /*
There are 2 xpaths:
- Absolute: / => This is almost never used in Testing.
        This is the absolute path just like navigating to a folder in the computer
        ex: Find the absolute path of password in "http://a.testaddressbook.com/sign_in"
        //html/body/div/div/div/div/form/div[2]/input

        ex: Find the absolute path of Sign in button in "http://a.testaddressbook.com/sign_in"
        //html/body/div/div/div/div/form/div[3]/input

        Note that indexes do start from 1 !!!

  *** easy to way to find the absolute path:
  right click on the respected element >> copy>> full Xpath :)
    /html/body/div/div/div/div/form/div[3]/input
We must not use absolute xpath because the path may be easily broken whenever an element is added or removed


- Relative:// =>
     Note we say xpath it refers to relative Xpath
There are multiple ways to form relative xpath
    - The most common syntax: //tagName[@attribute='value'];
        - //* means any tag
        - //* [.='value'] means any tag and any attribute with the value of 'value'
       ex: //*[@class='form-control'][2] => any tag with the class attribute's value 'form=control' then 2nd one.
ex: find the xpath of the following email element
<input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">

          input[@placeholder='Email']
    //input[@placeholder='Email']

  Headsup:
    or  //input[@class='form-control']  there are 2 elements with this Xpath.
    So we should specify the right one with index
  (//input[@class='form-control']) [1]



*/
WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void xpathTest() {
//Lets sign in with xpath

    driver.get("http://a.testaddressbook.com/sign_in");
    driver.findElement(By.xpath("//input[@placeholder='Email']")).
            sendKeys("testtechproed@gmail.com");
    driver.findElement(By.xpath("//input[@placeholder='Password']")).
            sendKeys("Test1234!");

    driver.findElement(By.xpath("//input[@name='commit']")).click();


    }




}
