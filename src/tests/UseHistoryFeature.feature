Feature: As a user, I want to be able to use a result from a previous operation
  as input for a new operation so that I do not have to re-enter the number.
  Scenario: Reading from a history that has items
    Given a calculator history with the integer 6
    When the user enters factorial
    And the user enters !1
    Then the result should be 720
  Scenario: Reading from a history with no items
    Given an empty calculator history
    When the user enters factorial
    And the user enters !1
    Then the result should be Incorrect parameters provided