package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest() throws InterruptedException {

        /*
    go to https://the-internet.herokuapp.com/upload
User selects an image
Uploads a file ()image
verify the file uploaded

     */

        driver.get("https://the-internet.herokuapp.com/upload");
//        driver.findElement(By.cssSelector("#file-upload")).click(); do not click!!! :
//        we should not "click" because we can not handle windows with Selenium (we can handle just browsers).
//        So we use Java to sendKeys to this WebElement.
       // Note this element is an "Input" element with input tag. So we can use sendKeys() method:
       // <input id="file-upload" type="file" name="file">

        String homePath = System.getProperty("user.home");
        System.out.println(homePath);

        WebElement chooseFileElement = driver.findElement(By.cssSelector("#file-upload"));

        Thread.sleep(5000);
        String flowerPath = homePath+"/Desktop/flower-color-400x391.jpg";
        /* we can find the path by copying the file into the terminal also:
        1. open the terminal
        2. Open the location of the file (we can use finder).
        3. Drag and drop the file into the terminal
        4. Copy the displayed path
        5. Note start copying from left to be able to copy :)
        String path = /Users/bilalcevik/Desktop/flower-color-400x391.jpg;
        */
        chooseFileElement.sendKeys(flowerPath);

    driver.findElement(By.cssSelector("#file-submit")).click();
    Assert.assertTrue(driver.getPageSource().contains("File Uploaded!"));
    //or
    Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText().contains("File Uploaded!"));
    // or with a slight change after getText().equals ...
    Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText().equals("File Uploaded!"));

    }



}
