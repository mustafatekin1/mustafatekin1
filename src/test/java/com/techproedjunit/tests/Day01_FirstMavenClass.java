package com.techproedjunit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_FirstMavenClass {
	/*
- Maven is a Java build and Java project management tool owned by Apache software foundation.
- With Maven we can manage the entire automation process
- We can manage the dependencies via "pom.xml" file.  So we do not need to add jar file.
	** We will just add the respected dependency from the website.
	** Maven will automatically download the related dependency instead of requirements adding jar files

- We will compile, run and deploy Java applications.
- Devs also use Maven
- Some other similar tools like Maven is Ant and Gradle. Maven is the most popular.
-

- We will not repeat the test codes in every class which we have done in the com.techproedjavaproject test package.
*/

	/*
Adding Selenium Dependencies
1. selenium dependency
- search maven repository and go to mvnrepository.com
- Search selenium inside the website
- Copy the Maven dependency
- Paste that into the pom file
 ** important: open and close the dependencies tag: <dependencies></dependencies>
 ** paste that between <dependencies></dependencies> tag.

- If there is red in Intelij (I did not see in Eclipse),
click circle at the top right? - check if this works!!! Probably this is because refresh issue.
 Adding the following properties may be beneficial. It is to be safe:
 <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

2. WebDriverManager dependency
- Search for WebDriverManager
- Select the first one bonigarcia.dev/WebDriverManager

*** POM : Project Object Model
This is the most imoortant file of Maven.
There are dependencies, plug-ins, profiles, configurations

3. JUnit dependency
add the
2. junit » junitEPL
JUnit is a unit testing framework for Java, created by Erich Gamma and Kent Beck.
*/

    public static void main(String[] args) {
        // we do not need System.setProperty()
   //Instead we use WebDriverManager dependency from bonigarcia
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.close();

    }

}