package com.techproedjunit;

public class Day05_CssLocator {

    /*
 The url: http://a.testaddressbook.com/sign_in

    xpath for the email          ==> //input[@id='session_email']

    css selector/locator for the email: just "remove the backslashes and @"
                                ==> input[id="session_email']

   *** if there is id we can write cssSelector shorter with #:
  #session_email ==> is the cssSelector for the email with id attribute.
  or
  input#session_email ==> is also cssSelector for email with id attribute.

  *** if there is class we can write cssSelector shorter with .  :
  input.form-control ==> is the cssSelector for email with class attribute
  .form-control  ==> is the ccsSelector for email with class attribute

  We can not use the [] indexes in cssSelector
  And since classes are unique and index problem, using css with class attribute is not recommeneded

 */




}
