Feature: List cloudwise employees from 9 departments and find the duplicate names

  Scenario Outline: Navigate to different departments and list the employees
    When User is now on "Cloudwise helpt scholen met moderne ICT oplossingen | Cloudwise" page
    And User accepts the cookie
    And User hovers on Dit is Cloudwise from the main navigation of the page
    And User clicks on Alle Cloudwisers
    And User is now on "Alle Cloudwisers - Cloudwise" page
    When User clicks on all the departments and get all the employees
    Then Print all the members names as per the department
