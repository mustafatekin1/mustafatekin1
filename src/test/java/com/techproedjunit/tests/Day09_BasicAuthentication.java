package com.techproedjunit.tests;

import com.github.javafaker.Bool;
import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day09_BasicAuthentication extends TestBase {
    /*
One way : we use the following syntax to authenticate:
//https:username:password@url

go to https://the-internet.herokuapp.com/


  */

    @Test
    public void authenticate(){

        // driver.get("https://the-internet.herokuapp.com/basic_auth"); ==> we do not use this!!!
//https:username:password@url ==> in this case
// -- user name is admin
// -- password is admin
// -- url : the-internet.herokuapp.com/basic_auth
// ==> https://admin:admin@the-internet.herokuapp.com/basic_auth ==> This is our url
        //driver.get("https://adm:admin222@the-internet.herokuapp.com/basic_auth");
        // please note that although the entered "user" and "password" is wrong, the test passed
        // Because the entered url opens and the test passes.
        // So we have to verify with "Congratulations" message for example.

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement congratMessage = driver.findElement(By.xpath("//*[contains(text(), 'Congratulations!')]"));
                       // The xpath can be as follows also:     "//p[contains(text(), 'Congratulations')]"
        Assert.assertTrue(congratMessage.getText().contains("Congratulations!"));

        // or second way, slight difference with Boolean and isDisplayed

        Boolean isDislayed = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations')]")).isDisplayed();
        Assert.assertTrue(isDislayed);

    }

}
