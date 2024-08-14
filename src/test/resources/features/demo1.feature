@data
Feature: This is a test feature-2

  Scenario: sign up a account-2-1
    Given hit login button on main screen
    And hit sign up tab
    And fill in account info
    When hit sign up button
    Then successfully sign up a account

  Scenario: drag and drop-2-2
    Given hit drag button on main screen
    And drag image to target