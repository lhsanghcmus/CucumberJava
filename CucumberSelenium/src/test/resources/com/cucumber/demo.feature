#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Test login to Attendance Management

  
  Scenario: Login with valid username and password
    Given I open web "https://stlqv.herokuapp.com/login"
    When I enter username is "stlqv" and password is "vietnam"
    And I click on login button
    Then I login successfully
    
   Scenario: Login with valid username and invalid password
   	Given I open web "https://stlqv.herokuapp.com/login"
   	When I enter username is "stlqv" and password is "vietnam1"
   	And I click on login button
   	Then I receive "Wrong password"
   
		Scenario: Login with invalid username and valid password
			Given I open web "https://stlqv.herokuapp.com/login"
   		When I enter username is "leonguyen2" and password is "vietnam"
   		And I click on login button
   		Then I receive "Username not found"
