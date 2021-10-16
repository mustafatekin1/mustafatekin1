package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day09_Javascript_Executor extends TestBase {
    /*
suggestion: start automating some pages.  ex: realtor.com

Javascript executor is uses to handle some browser events
- scroll up/down/left/right
- scroll into element
- click
- generate alert
- change color
...


  */
// 1. create javascript executor at the test method level. In the class level it did not work
    // we create it from driver. So we have to "cast"

    @Test
    public void scrollIntoView() throws InterruptedException {
/*
Task:
go to http://carettahotel.com/
verify the text "Recent Blog" is on the page
Scroll to that element
 */
        driver.get("http://carettahotel.com/");

        // we have to scroll otherwise it fails
        // scroll to the element by using javascript executor

        WebElement recentBlog = driver.findElement(By.xpath("//*[.='Recent Blog']"));

   // 1. create javascript executor
   // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recentBlog);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true)", recentBlog);



        //Wait  a little so that the page scrolls down. We can use also explictlyWait
        Thread.sleep(3000);
        boolean isRecentBlogDisplayed = recentBlog.isDisplayed();
        Assert.assertTrue(isRecentBlogDisplayed);


    }


}
