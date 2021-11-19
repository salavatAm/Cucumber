Feature: Login user

  Scenario: Login user and go to my service
    Given I am on sign in page
    Then I input login and password
    And I need to see "salavatamingaliev" on profile page
    And I go to services page
    Then logout