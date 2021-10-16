package com.techproedjunit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Day02_LocatorsIntro {
/*
To locate the web elements in the UI:
Step 1 :
1st way: right click>> insect >> click on the arrow sign(<-) once then click on the element
2nd way: right click>> inspect>> directly right-click on the desired web element
Step 2 : Use one of the 8 selenium locators:
-- id, name, className, tagName, linkText, partialLinkTest, xpath (multiple ways), css (multiple ways)
 */

    /*
    The Task: go to http://a.testaddressbook.com/sign_in
    Locate the elements of email textbox, password textbox, signin button
    Enter below user name and pw:
     username :   testtechproed@gmail.com
     password : Test1234!
    Then verify that the user id testtechproed@gmail.com (Use getText() method to get text from the page)
    Verify Addresses and Sign Out texts are displayed.
    Find the number of total link on the page
    Sign out from the page

    (This task is may be more than 2 sprints so it should be splitted into more user stories.
    Because, there should be many other negative scenarios.
    We did this in an hour but this is already developed and we did not focus on negative scenarios!)
     */

    WebDriver driver; // with this variable, I can use driver in all methods in the class.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void teardown(){
    driver.close();
    }

    @Test
    public void locators() throws InterruptedException {
    driver.get("http://a.testaddressbook.com/sign_in");
    driver.findElement(By.id("session_email")).// locate the element by id
        sendKeys("testtechproed@gmail.com"); //

        // we can assign a variable for the findElement (this returns web element)
//    WebElement passwordBox = driver.findElement(By.id("session_password"));
//    passwordBox.sendKeys("Test1234!");

        // Lets locate the password with name attribute as there is name attribute
        driver.findElement(By.name("session[password]" )).sendKeys("Test1234!");

// Lets locate and click on signin button
//  driver.findElement(By.className("btn btn-primary" )).click();
// *** When there is a space or special character do not use that locator
driver.findElement(By.name("commit")).click();

     WebElement userId = driver.findElement(By.className("navbar-text"));
     //If there are multi-match, the first one is returned with the return type WebElement.
     // findElement(by...) if no match throws exception: No Such Element Exception
     // findElements(by...) returns a list even if just one match or no match
        System.out.println(userId);// we get hashcode

     String userIdText = userId.getText();
        System.out.println(userIdText);
//assertTrue(userIdText == "testtechproed@gmail.com");// please note that == fails. we have to use .equals() method
        assertTrue(userIdText.equals("testtechproed@gmail.com"));

        //Verify Addresses and Sign Out texts are displayed.
        // Teacher's way is a better way with a method of WebElement.
        WebElement address = driver.findElement(By.linkText("Addresses"));
        // linkText is the name of the link. We can even get the link name/text from the UI.
        assertTrue(address.isDisplayed()); // is the WebElement displayed or not?
        // we can directly use as the following also:
        assertTrue(driver.findElement(By.linkText("Addresses")).isDisplayed());
        System.out.println("is Addresses displayed: " + address.isDisplayed());

    WebElement signOut = driver.findElement(By.linkText("Sign out"));
    assertTrue(signOut.isDisplayed());
        System.out.println("is Sign out displayed: " + signOut.isDisplayed());

        // we can also find the solution for Sign out with partialLinkText also:
        WebElement signOut2 = driver.findElement(By.partialLinkText("Sign out"));
        assertTrue(signOut2.isDisplayed());
        System.out.println("is Sign out displayed: " + signOut2.isDisplayed());
 /*The difference between partialLinkText and linkText:
 We can give just a part of the link in partialLinkText
 we get the sme result when we give a part of the link text. Lets execute `Sign out` with 'gn ou`
         of course we should be careful in case the same entered text can be the same with some other elements */
WebElement signOutPartial = driver.findElement(By.partialLinkText("gn ou"));
assertTrue(signOutPartial.isDisplayed());
System.out.println("is Sign out displayed when partially entered as just 'gn ou': " + signOutPartial.isDisplayed());


/*
Find the number of total links on the page: We should use findElements()
 How do we understand if an element is link or not
 - all links have a tags. So the question is how many a tags are there?
 */
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println(linksList);
        System.out.println("The number of links on the page is : " + linksList.size());


       // Sign out from the page
driver.findElement(By.partialLinkText("ign ou")).click();
        Thread.sleep(2000);

/*
        How to be sure that we sign out. What can be automation for this?
        - we can check if we reach the expected url eg: "http://a.testaddressbook.com/sign_in"
        - we can check if a core element is displayed which we expect after Sign out such as Sign in ...
*/

        Boolean isSignedOut = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
        assertTrue(isSignedOut); // it is more readable. It is better to have reusable methods.
        System.out.println("Is it signed out? " + isSignedOut);




    }

}
