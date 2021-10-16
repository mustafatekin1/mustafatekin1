package com.techproedjunit.tests;

import org.junit.Assert;
import org.junit.Test;

public class Day02_JunitFirstClass {
    /*
 Junit is the most basic Java testing framework
 We can rus test scripts with Junit
 TestNG is advanced version of JUnit
 Cucumber is also testing framework

 Annotations:
 - @Test, @Before, @After, @AfterClass, @BeforeClass, @Ignore
 @Test : used to create and run test cases(the test methods with @Test annotations). This is like our main method in testing
 @Before:  is used for repetitive pre conditions, is executed before each test case
 @After : is used for repetitive post conditions, is executed after each test case
 @BeforeClass: is used for repetitive pre conditions for the class
 @AfterClass:
 Ignore: is used to skip the test cases (the test methods with @Test annotations)

 There are more annotations in TestNG

      */
//Assertions: We use them if expected = actual ?

    @Test
    public void assertion (){
        Assert.assertTrue(10==(5+5)); // pass
        Assert.assertFalse(10==(3+3)); // pass
        Assert.assertEquals(10, (5+5)); // pass

        //Assert.assertFalse(10==(5+5)); // fails because the statement is true
        Assert.assertFalse("Selenium".contains("a"));// pass


    }



}
