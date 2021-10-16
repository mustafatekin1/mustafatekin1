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

public class Day06_Iframes {
    /*
    iFrame is HTML inside another HTML (nested htmk :) )
    We create iframe with <iframe> tag
    note: The difficulty is we can not locate the iframe directly.
    The syntax is similar to alerts.
    We also have to specify the iframe with one of 3 ways:
        - index, id/class or WebElement/xpath of iframe
        driver.switchTo().frame(...)
    Upon switching to iframe (child frame), we have to switch to parent frame when required

    Here is the task:
    go to https://the-internet.herokuapp.com/iframe
// verify the bold text contains "Editor"
// Locate the text box
// Delete the text in the text box
// Type "This text is inside the iframe
// Verify that Elemental Selenium is displayed
    */

    WebDriver driver;
    @Before
    public void start () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iFrameTest() throws InterruptedException {
// verify the bold text contains "Editor"
       String boldText = driver.findElement(By.xpath("//*[contains(text(), 'Editor')]")).getText();
       String containedText = "Editor";
        Assert.assertTrue(boldText.contains(containedText));
// Locate the text box
// We have to first switch to iframe. The following is the iframe in this case:
    /*<iframe id="mce_0_ifr" frameborder="0" allowtransparency="true" title="Rich Text Area.
 Press ALT-0 for help." class="tox-edit-area__iframe"></iframe> */

        //1st way switch to iframe with index
    //WebElement textBoxInIframe = driver.switchTo().frame(0).findElement(By.xpath("//p"));
        //2nd way with switch to iframe with id/name (Note it takes too much time==> about 75 seconds)
//WebElement textBoxInIframe = driver.switchTo().frame("mce_0_ifr").findElement(By.xpath("//p"));

//3rd way: switch to iframe with WebElement
WebElement iFrameElement = driver.findElement(By.cssSelector("#mce_0_ifr"));
WebElement textBoxInIframe = driver.switchTo().frame(iFrameElement).findElement(By.xpath("//p"));

// Delete the text in the text box
        Thread.sleep(2000);
        textBoxInIframe.clear();
// Type "This text is inside the iframe"
        textBoxInIframe.sendKeys("This text is inside the iframe");

// Verify that Elemental Selenium is displayed
        // note we have to switch to parent frame
   //1st way with parentFrame
        // String actualText = driver.switchTo().parentFrame().findElement(By.partialLinkText("Elemental")).getText();
   //2nd way with defaultContent
        String actualText = driver.switchTo().defaultContent().findElement(By.partialLinkText("Elemental")).getText();
        System.out.println(actualText);
    String expectedText = "Elemental Selenium";
    Assert.assertTrue(actualText.contains(expectedText));
            // 2nd way to assert:
        WebElement elementalSelenium = driver.switchTo().defaultContent().findElement(By.partialLinkText("Elemental"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }

    @After
    public void teardown() throws InterruptedException {
       Thread.sleep(4000);
        driver.close();
    }
}
