Feature: Generate Testing Data
  Scenario: Verify CNP for 5 person to be valid
    Given Testing Challenge URI is open
    When CNP Number is generated for the following five Persons
    |gender|dateOfBirth|isForeignResidentInRomania|isNonResident|areaCode|orderNumber|
    |Male  |1999/01/25 |false                     |    false    |  33    |    001    |
    |Female|1899/12/30 |false                     |   false     |  18    |    002    |
    |Female|2000/01/22 |false                     |   false     |  52    |    003    |
    |Female|1900/01/02 |true                      |   false     |   1    |    004    |
    |Female|1900/01/02 |false                     |   true      |   4    |    005    |
    Then title of the page should be visible
    And submit of generated CNPs should be successful
    And Congratulation message should be displayed
