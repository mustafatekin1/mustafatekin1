package com.techproedjunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day07_WindowHandle {
/* syntax: driver.switchTo().window(the string for the specific windowhandle);
switchTo().window(the string for the specific windowhandle) => switches between windows
driver.getWindowHandle()  => Returns String -- String of the handle of page the driver "currently" controlling
driver.getWindowHandles() => Returns Set  -- get the handles of all open pages
The switching window logic is as follows:



     Here is the task:
    go to https://the-internet.herokuapp.com/windows

   verify the text: Opening a new window
   verify the title is "Internet"
   When user clicks on "Click here" button
   New window's title is "New Window"
   Then verify the text "New Window"

   Then go back to the previous window and verify the title is "The Internet"


  */
WebDriver driver;
@Before
    public void start(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    driver.get("https://the-internet.herokuapp.com/windows");

    }
    @Test
    public void windowHandle(){
// verify the text: Opening a new window
        String headingElement = driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        String expectedHeadingElement = "Opening a new window";
        System.out.println(headingElement);
        Assert.assertEquals(expectedHeadingElement, headingElement);
//verify the title is "Internet"
    String firstWindowTitle = driver.getTitle();
    String expectedfirstWindowsTitle = "The Internet";
        System.out.println(firstWindowTitle);
        Assert.assertEquals(expectedfirstWindowsTitle, firstWindowTitle );
//When user clicks on "Click here" button
        driver.findElement(By.partialLinkText("Click")).click();
        //Although the new window opens, the driver is still on the first window,
        // So we have to switch to window 2
        // How to switch:
 // 1.STEP is to assign the current window to a String container
        String window1Handle = driver.getWindowHandle();
 // 2.Step is to get all window handles with getWindowHandles()  method which returns Set
        Set<String> allWindowHandles = driver.getWindowHandles();
 // 3.STEP is to switch to new window handle via each loop
        for (String eachWindowHandle:allWindowHandles) {
            if(!eachWindowHandle.equals(window1Handle)) {
                driver.switchTo().window(eachWindowHandle);
                break;
            }
        }
        //New window's title is "New Window"
        String secondTitle = driver.getTitle();
        System.out.println("Second title from Teacher's solution: " + secondTitle);
        String expectedSecondTitle = "New Window";
        Assert.assertEquals(expectedSecondTitle, secondTitle);

    // 3. STEP my solution slightly different:
        String window2Handle = "";
        for (String eachWindowHandleee:allWindowHandles) {
            if (!eachWindowHandleee.equals(window1Handle)) {
                window2Handle = eachWindowHandleee;
                break;
            }
        }
        String secondTitleFromMySolution = driver.switchTo().window(window2Handle).getTitle();
        System.out.println("Second Title from my solution : " + secondTitleFromMySolution);
        Assert.assertEquals(expectedSecondTitle, secondTitleFromMySolution);

//   Then verify the text "New Window"
    String textOfSecond = driver.findElement(By.xpath("//h3[.='New Window']")).getText();
    String expectedTextSecondWindow = "New Window";
        System.out.println("Text of Second window: " + textOfSecond);
        Assert.assertEquals(expectedTextSecondWindow, textOfSecond);

// Then go back to the previous window and verify the title is "The Internet"
 String firstWindowTitleAgain=  driver.switchTo().window(window1Handle).getTitle();
        System.out.println(firstWindowTitle);
        Assert.assertEquals(expectedfirstWindowsTitle, firstWindowTitleAgain);

        System.out.println(window1Handle);//we just get hash codes from this!!
        System.out.println(window2Handle);//we just get hash codes from this!!


    }


    @After
    public void teardown(){
    driver.quit();
    }

}
