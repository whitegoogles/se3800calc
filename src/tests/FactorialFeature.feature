Feature: As a user, I want to be able to calculate the factorial of a positive integer
  so that I can know its value.
  Scenario Outline: Calculating the factorial of several different number options
    Given the calculator is in factorial mode
    When the user enters a factorial value of "<opOne>"
    Then the result should be "<factorial>"
    Examples:
      |opOne      |factorial                      |
      |6          |720                            |
      |-4         |Parameters were negative       |
      |0          |1                              |
      |NaN        |NaN                            |
      |Infinity   |Infinity                       |
      |-Infinity  |Parameters were negative       |
