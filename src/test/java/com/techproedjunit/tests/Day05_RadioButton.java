package com.techproedjunit.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day05_RadioButton {
    /* The following is similar to SMOKE TEST
Task Radio Button:
-go to https://www.facebook.com
- click on create account
- Enter all the info with locators
- Locate the elements of radio buttons
- Click on radio buttons of gender if not selected


 */

    Faker faker = new Faker();
    WebDriver driver;
    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void radioButton(){
        driver.get("https://www.facebook.com");
        // driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        driver.findElement(By.partialLinkText("Yeni Hesap O")).click();// since it is a link
        // (we easily understand from the <a   > tag)
//        driver.findElement(By.name("firstname")).sendKeys("Mustafa");
//        driver.findElement(By.name("lastname")).sendKeys("Tekin");
//        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("was22@qa.team");
//        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Test1234!");

        //Lets do it with faker data
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("was223@qa.team");
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys(faker.internet().password());

//        driver.findElement(By.cssSelector("#day")).sendKeys("03");
//        driver.findElement(By.cssSelector("#month")).sendKeys("Kas");
//        driver.findElement(By.xpath("//*[@name='birthday_year']")).sendKeys("1980");

       //Lets select from the dropdown menu with our new knowledge from Day05_DropDown class
        WebElement dayDropDown = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(dayDropDown);
        selectDay.selectByIndex(3);

        WebElement monthDropDown = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(monthDropDown);
        selectMonth.selectByValue("10");

        WebElement yearDropDown = driver.findElement(By.name("birthday_year"));
        Select selectYear = new Select(yearDropDown);
        selectYear.selectByVisibleText("1990");

        WebElement maleOption = driver.findElement(By.xpath("//*[text()='Erkek']"));

        if (!maleOption.isSelected()) {
            maleOption.click();
        }

        driver.findElement(By.name("websubmit")).click();
        // we can not create accoun since it requires us to rewrite email after clicking signup

        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("was223@qa.team");
        driver.findElement(By.name("websubmit")).click();
    }

    @After
    public void teardown() throws InterruptedException {
    Thread.sleep(3000); // I just add this to see the result
        //driver.close();
    }

}
