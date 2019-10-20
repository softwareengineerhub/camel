Feature: Person feature

  Some person behaviour

  Scenario: Person validation
    Given  Person with next values
      | NAME  | AGE |
      | Denis | 32  |
    And Person with next values
      | LAST_NAME | YEAR_OF_BIRTH |
      | Prokopiuk | 1986          |
    Then expect the person is updated with below details
      | NAME  | AGE | LAST_NAME | YEAR_OF_BIRTH |
      | Denis | 32  | Prokopiuk | 1986          |
    When expect the person is updated with below details
      | NAME  | AGE | LAST_NAME | YEAR_OF_BIRTH |
      | Denis | 32  | Prokopiuk | 1986          |