#Author: robin.pierre16@outlook.com
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

Feature: Traversing the profile page
  I want to traverse the profile page



	
  @Trainer
  Scenario Outline: I want to add a skill
    Given I am logged on as a trainer
    And I am on the profile page
    When I click on <skill>, which I want to add
    And I save the skills
    Then 	I should see <skill> on my list of skills
    
    Examples:
    |skill|
    |"Not William WebDriver"|
    |"Robin Script" |
    |"Manual Testing" |
    |"TestNG"|
   
   Scenario Outline: I want to remove a skill
   	Given I am on the profile page
   	When I click on <skill>, which I want to remove
   	And I save the skills
   	Then I should see <skill> on the list of skills to choose from
   	
   	Examples:
    |skill|
    |"Not William WebDriver"|
    |"Robin Script" |
    |"Manual Testing" |
    |"TestNG"|
   

      
