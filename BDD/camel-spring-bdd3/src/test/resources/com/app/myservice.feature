Feature: MyService

  MyService feature

  Scenario: Adding two numbers
    Given I am going to notify Service
    When Me add 1 and 2
    Then Me should get 3

  Scenario: Subtracting two numbers
    Given I am going to notify Service
    When Me subtract 10 and 11
    Then Me should get -1