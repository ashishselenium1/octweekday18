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
@Portfolio
Feature: Creation and deletion of portfolio
  I want to create and delete portfolios

  @CreatePortfolio
  Scenario: Create a Portfolio
    Given I open Chrome
    And I navigate to loginPage
    When I login with default username and password
    Then Login should be success
    When I click on createPortfolioButton_id
    And I clear portfolioNameText_xpath
    And I type Dec18 in portfolioNameText_xpath
    And I click on createPortfolioSubmitButton_xpath
    Then Portfolio should be created successfully
    
    
    