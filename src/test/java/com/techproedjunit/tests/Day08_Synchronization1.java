package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day08_Synchronization1 extends TestBase {


    @Test
    public void synchronisation1(){

/*
go to https://the-internet.herokuapp.com/dynamic_controls
click on remove button
verify the message "It's gone"
click on "Add"
verify the message "It's back"
 */

driver.get("https://the-internet.herokuapp.com/dynamic_controls");
driver.findElement(By.xpath("//button[@onClick='swapCheckbox()']")).click();

// I comment out implicit wait in TestBase then we use the following "Explicit Wait"

WebDriverWait wait1 = new WebDriverWait(driver, 10);
//WebElement goneElement = driver.findElement(By.xpath("//p[@id='message']"));
WebElement goneElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

Assert.assertEquals("It's gone!", goneElement.getText());

driver.findElement(By.xpath("//button[@onClick='swapCheckbox()']")).click();
//WebElement messageBack = driver.findElement(By.xpath("(//*[contains(text(), 'back!')])[2]")); // i used the contains to exercise
WebElement messageBack = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), 'back!')])[2]")));
Assert.assertEquals("It's back", messageBack.getText());



    }







}
