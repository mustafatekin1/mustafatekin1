package com.techproedjunit.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    //We make the class "abstract" because we do not want anyone to create objects from this class.

    protected WebDriver driver; // it must be either public or protected. otherwise this will complain in the test class.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//must
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);//optional
    }

    @After // later we will add reports in here also
    public void tearDown(){
        driver.close();
    }


}
