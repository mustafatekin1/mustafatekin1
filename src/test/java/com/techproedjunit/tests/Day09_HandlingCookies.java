package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day09_HandlingCookies extends TestBase {
    /*
Cookies: The temporary data that is created by the browser
They are stored in the computer as we visit the websites.

We can automate handling cookies:
- find
- add
- delete

Each website has different cookies

Task:
- go to https://www.amazon.com
    1. find the total number of cookies
    2. print cookies
    3. get cookies by name
    4. add new cookie
    5. delete some certain cookies by name
    6. delete all cookies

  */
    @Test
    public void handlingCookies () {

        driver.get("https://www.amazon.com");
//        1. find the total number of cookies
        Set<Cookie> setOfCookies = driver.manage().getCookies();// returns all of the cookies as Set
        int totalNumberOfCookies = setOfCookies.size();
        System.out.println("totalNumberOfCookies is "+totalNumberOfCookies);

//        2. print cookies
       // As the setOfCookies is a set. We have to print them from a loop.
        for (Cookie eachCookie:setOfCookies) {
            System.out.println("each name: "+eachCookie.getName());
            System.out.println("each value: "+eachCookie.getValue());
        }

//        3. get cookies by name :  i18n-prefs (I select a cookie name from the console)
        Cookie named1_i18n_prefs = driver.manage().getCookieNamed("i18n-prefs");

        System.out.println("the cookie named -i18n-prefs:  " + named1_i18n_prefs);
        System.out.println("value of the named ... " + named1_i18n_prefs.getValue());

//        4. add new cookie
        Cookie myCookie = new Cookie("my cookie" , "How does my cookie look like");
        driver.manage().addCookie(myCookie);
        totalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("New total number is : " + totalNumberOfCookies);

        Set<Cookie> newSetOfCookies = driver.manage().getCookies();
        for(Cookie eachCookie : newSetOfCookies) {
            System.out.println("new cookie in the new set: " + eachCookie );
        }

//        5. delete some certain cookies by name
        driver.manage().deleteCookieNamed("skin"); // by name of the cookie
        driver.manage().deleteCookie(named1_i18n_prefs); // by the cookie
        totalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("newer total number = " + totalNumberOfCookies);

//        6. delete all cookies
    driver.manage().deleteAllCookies();
    totalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("newest total number = " + totalNumberOfCookies);



    }

}
