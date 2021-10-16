package com.techproedjunit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class Day06_Alerts {
/*  note: The difficulty is we can not locate the alert.
    https://the-internet.herokuapp.com/javascript_alerts
    How can we handle the 3 alerts in the page
   *** 1st Test method:
    - create test methods for accept()
    - verify that the alert is "I am a JS Alert"
    - verify that "You successfully clicked an alert" is displayed after click OK
   *** 2nd Test method
    - click on the second button on https://the-internet.herokuapp.com/javascript_alerts
   - verify the text "I am a JS Confirm"
   - dismiss the alert
   - verify the text "You clicked: Cancel"

 *** 3rd Test method
    - click on the third button on https://the-internet.herokuapp.com/javascript_alerts
   - verify the text "I am a JS prompt"
   - send keys "Hi guys"
   - verify the text "You entered: Hi guys"


 */

    WebDriver driver;
    @Before
    public void start () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptTest() throws InterruptedException {
       driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
       //- verify that the alert is "I am a JS Alert"
       String alert1 = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert", alert1);
        Thread.sleep(2000);

     //   verify that "You successfully clicked an alert" is displayed after click OK
       driver.switchTo().alert().accept();
       String successMessage =  driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(successMessage);
    Assert.assertEquals("You successfully clicked an alert", successMessage);
    }

    @Test
    public void dismissTest(){
    driver.findElement(By.xpath("(//*[.='Click for JS Confirm'])[2]")).click();
    String alert2 = driver.switchTo().alert().getText();
        System.out.println(alert2);
        Assert.assertEquals("I am a JS Confirm", alert2);

        driver.switchTo().alert().dismiss();
        String cancelMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("Messages do not match","You clicked: Cancel", cancelMessage);

    }

    @Test
    public void sendKeysTest() throws InterruptedException {
    driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
    String alert3 = driver.switchTo().alert().getText();
    Assert.assertEquals("I am a JS prompt", alert3);

    driver.switchTo().alert().sendKeys("Hi guys!");
    Thread.sleep(2000);
    driver.switchTo().alert().accept();
        Thread.sleep(2000);
    String sentMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
    Assert.assertEquals("You entered: Hi guys!", sentMessage);
    }

    @Test
    public void getTextTest(){

    }

    @After
    public void teardown() {
    driver.close();
    }


}
