package com.techproedjunit.tests;

import com.techproedjunit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest {

@Test
    public void isExist() {
    /* Check if a file exists or not in the computer.
    We need to use Java for this. (Selenium can not.)
    */
//The following code gets the HOME directory of the computer by Java
String homePath = System.getProperty("user.home");
    System.out.println(homePath); // we add /Desktop/then the file

    String flowerPath = homePath+"/Desktop/flower-color-400x391.jpg";
    // For windows use : \\ backward double slashes

    System.out.println(flowerPath);
    Boolean isExisting = Files.exists(Paths.get(flowerPath));
    System.out.println(isExisting);

    Assert.assertTrue(isExisting);




}








}
