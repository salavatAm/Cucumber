Feature: Login user and upload file

  Scenario: Download file
    Given I go to sign in page
    When I login
    And I should see "salavatamingaliev" on profile page
    And I visit "yandexDrive" page
    And I upload file with name "Amingaliev1.xlsx"
    Then I should see file with name "Amingaliev1.xlsx" on page
    And I logout


