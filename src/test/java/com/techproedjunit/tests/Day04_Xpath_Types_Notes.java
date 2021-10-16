package com.techproedjunit.tests;

public class Day04_Xpath_Types_Notes {
    /*
The web url we exercise on this class is "https://qa-environment.resortsline.com/"
<h2 class="mb-4">Welcome To Our Hotel</h2>
How to locate with xpath (some different ways)

- We can locate index (not recommended. If possible there should be no indexes)
    1. Command F in the inspect
    2. Type ==> //h2 (the tag of the element)
    3. Observe the number of the found h2
    4. Then start clicking on Enter and observe the UI to move to the right element
    5. Note the index ex: 7 (7 of 15)
    6. Then the xpath ==> (//h2)[7]

//tagName[.='The exact text of the element'] : locates the tag which has the exact text
- lets create an xpath with this syntax : //tagName[.='The exact text of the element']
    //h2[.='Welcome To Our Hotel']

//*[.='The exact text of the element'] : locates the first element which has the exact text
//*[.='Welcome To Our Hotel']

//*[text()='The exact text of the element'] : locates the first element which has the exact text
//*[text()='Welcome To Our Hotel']

//*[contains(text(), 'A piece of the text of the element')]
  //*[contains(text(),'Welcome To O')]

Handling Dynamic elements using attributes and values
//Tag[contains(@attribute, 'some part of the value of the attribute')]
 //h2[contains(@class, 'mb')] ==> returns the first
or
 //ul[contains(@class, 'ftco-footer-')]  ==> gives the social media list element on the page
  //input[contains(@id, 'checkin_d')] == gives the checkin date element on the page
*/

    /*
     Handling dynamic elements (it is too rare but can be asked ij interviews)
What does the dynamic mean?
Some companies for example Facebook makes some elements dynamic. When refresh the id changes. This is on purpose for some
security reasons. For example to prevent creating accounts by using automation

We need to handle those elements dynamically
We use contains, starts-with or ends-with to handle them dynamically:
- //Tag[contains(@attribute, 'some part of the value of the attribute')]
- //Tag[starts-with(@attribute, 'some part of the value of the attribute')]
- //Tag[ends-with(@attribute, 'some part of the value of the attribute')]
https://www.facebook.com/ then click on create new account
(//input[starts-with(@id, 'u_')])[1]
(//*[contains(@id, 'u_')])[1]   ==> we can use others (starts-with, ends-with) also

*** We can add multiple attributes with "or" , "and".
https://www.facebook.com/ then click on create new account
Lets locate first name with multiple attributes
//*[@type='text' and @data-type='text' and @tabindex='0']

Lets locate male radio button with multiple attributes
//*[@type='radio' and @value='2']




*/
}
