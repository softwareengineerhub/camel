Feature: Calculator

  My simple feature

  Scenario: Adding two numbers
    Given I have a calculator
    When I add 1 and 2
    Then I should get 3

  Scenario: Subtracting two numbers
    Given I have a calculator
    When I subtract 10 and 11
    Then I should get -1