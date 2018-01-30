#Author: robin.pierre16@outlook.com
#Keywords Summary : feature file for the trainer page on assignforce

Feature: I want to navigate throughout the trainer page

@VP
Scenario: As a VP, I want to add a trainer
Given I want to go to the "https://dev.assignforce.revaturelabs.com"
And I login as "test.vpoftech@revature.com.int1" with a valid "yuvi1712"
When I login, I click on the trainers tab
Then I click on the add trainer button
Then I input "TestingR" and "TestingP" of the trainer
And I click save

@VP
Scenario: As a VP, I want to give paid time off
	Given I am on the trainers page
		When I click on the View PTO Calendar button
		Then I click new PTO Request
		But I click cancel PTO Request
		And I click cancel on the Calendar
		
@VP
Scenario: As A VP, I want to download a resume
	Given I am on the trainers page
		When I click on the Download Resume button
		Then I should get the downloaded resume
	

