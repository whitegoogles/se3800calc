Feature: As a user, I want to be able to multiply a list of integers together
  so that I can see their product.
  Scenario Outline: Multiplying several different integer list options
    Given the calculator is in multiply mode
    When the user types "<op1>"
    And the user types "<op2>"
    And the user types "<op3>"
    And the user types "<op4>"
    Then the product should be "<product>"
    Examples:
    |op1      |op2      |op3      |op4          |product                        |
    |1        |2        |3        |4            |24                             |
    |1156748  |2        |3        |400          |2776195200                     |
    |4000     |11156    |25687    |1            |1146256688000                  |
    |4000     |-4       |-4       |5            |320000                         |
    |4000     |-4       |4        |5            |-320000                        |
    |4000     |Infinity |-4       |NaN          |NaN                            |
    |1        |Infinity |-4000    |-5000        |Infinity                       |
    |2        |-4000    |Infinity |Infinity     |-Infinity                      |
    |1        |2        |-Infinity|-Infinity    |Infinity                       |
    |0        |-4000    |-Infinity|Infinity     |NaN                            |

  Scenario: Multiplying a list of integers that overflows to negative infinity
    Given the calculator is in multiply mode
    When the user types a big number
    And the user types a big number
    And the user types a negative number
    Then the product should be negative infinity

  Scenario: Multiplying a list of integers that overflows to infinity
    Given the calculator is in multiply mode
    When the user types a big number
    And the user types a big number
    And the user types a negative number
    And the user types a negative number
    Then the product should be infinity

