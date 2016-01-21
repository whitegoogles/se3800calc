Feature: Adding numbers together with the calculator
  Scenario Outline: Adding several numbers
    Given the calculator is in add mode
    When the user enters "<opOne>"
    And the user enters "<opTwo>"
    And the user enters "<opThree>"
    And the user enters "<opFour>"
    Then the sum should be "<sum>"
    Examples:
      |opOne    |opTwo    |opThree  |opFour   |sum                            |
      |1        |2        |4        |5        |12                             |
      |5        |802679   |420      |11111    |814215                         |
      |109749   |58299    |168048   |0        |336096                         |
      |1        |Infinity |-4000    |Infinity |Infinity                       |
      |1        |-Infinity|-4000    |-Infinity|-Infinity                      |
      |Infinity |-Infinity|-4000    |520      |NaN                            |
      |Infinity |-Infinity|NaN      |520      |NaN                            |

  Scenario: Adding two huge numbers (into overflowing)
    Given the calculator is in add mode
    When the user enters a really large number
    And the user enters a really large number
    Then the sum should be Infinity