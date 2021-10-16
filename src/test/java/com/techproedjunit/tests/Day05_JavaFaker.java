package com.techproedjunit.tests;

import java.util.Date;

import org.junit.Test;

import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

public class Day05_JavaFaker {
	/*
 We need data for testing.
 JavaFaker is used to get faked data
 We need JavaFaker dependency for this
 so we go to https://mvnrepository.com/ as usual to get the dependency
	*/


    @Test
    public void fakerTest() {

        Faker faker = new Faker();// create faker object

        // Generate any fake data
        String firstName = faker.name().firstName();
        String address1 = faker.address().fullAddress();
        Date date = faker.date().birthday();
        int num = faker.number().randomDigitNotZero();

        System.out.println(firstName);
        System.out.println(address1);
        System.out.println(date);
        System.out.println(num);

        System.out.println(faker.name().title());
        System.out.println(faker.address().city());
        System.out.println(faker.address().city());
        System.out.println(faker.address().state());
        System.out.println(faker.address().state());

        System.out.println(faker.number().digits(5));
        System.out.println(faker.phoneNumber());
        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.internet().emailAddress());


    }


}
