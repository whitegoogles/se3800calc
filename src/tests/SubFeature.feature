Feature: As a user, I want to be able to subtract a list of integers so that I can see
  what the difference between them is.
  Scenario Outline: Subtracting several different lists of values
    Given the calculator is in sub mode
    When the user inputs "<opOne>"
    And the user inputs "<opTwo>"
    And the user inputs "<opThree>"
    And the user inputs "<opFour>"
    Then the difference should be "<difference>"
    Examples:
      |opOne    |opTwo    |opThree  |opFour   |difference                     |
      |1        |2        |3        |4        |-8                             |
      |1156478  |2        |3        |400      |1156073                        |
      |109749   |58299    |168048   |0        |-116598                        |
      |1        |2        |4000     |Infinity |-Infinity                      |
      |1        |2        |-4000    |-Infinity|Infinity                       |
      |1        |Infinity |-4000    |-Infinity|NaN                            |
      |Infinity |-Infinity|400      |NaN      |NaN                            |
  Scenario: Subtracting really large integers that cause overflow
    Given the calculator is in sub mode
    When the user inputs a really large value
    And the user inputs a really large value
    And the user inputs a really large value
    And the user inputs a really large value
    Then the difference should be -Infinity