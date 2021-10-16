package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {
     /*
    go to https://the-internet.herokuapp.com/upload
 download any : flower-color-400x391.jpg
    verify the file downloaded
    (use Java Files.exists in order to verify and do not forget to add Thread.sleep() before asserting!!!)
     */

    @Test
    public void fileDownloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[.='flower-color-400x391.jpg']")).click();

       String homePath = System.getProperty("user.home");
       String downloadsPath = homePath+"/Downloads/flower-color-400x391.jpg";

        // We have to use Thread.sleep() for downloads because it takes time.
        // Implicit or explicit waits can not fix the problem. The download goes to Downloads folder of "Windows"
        Thread.sleep(1000);

        Boolean isExist = Files.exists(Paths.get(downloadsPath));
        System.out.println(isExist);

        Assert.assertTrue(isExist);
    }
}
