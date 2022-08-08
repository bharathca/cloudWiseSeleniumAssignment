# cloudWiseSeleniumAssignment

CloudWise web testing framework Assignment Web Automation Framework for CloudWise Assignment

Framework Description Framework is written in Java using BDD cucumber, and Selenium follows layered architecture for UI testing.

"src/test/resources/features" contains feature files written in Gherkin 
"src/test/java/cucumber.stepDefinition" contains all the step definitions 
"src/test/java/cucumber.runner" TestNG Runner 
"src/test/java/lib.selenium.base" contains selenium reusable functions 
"src/test/java/lib.selenium.design" contains ENUM for locators 
"src/test/java/pageObjects" contains all page objects 
"src/test/java/utils" contains Project

Core modules used

"Selenium-TestNG" -- Framework used to automate web 
"Cucumber" -- BDD Test framework 
"TestNG" -- Assertion library 
"ExtentReports" -- Reporter


Execute by performing the following 
Clone the repository
Import the same in the eclipse
Execute the project by "Run As" -> Maven Test

Extent report will be generated in the target-output folder

