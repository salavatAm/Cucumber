Feature: Login user and download file

  Scenario: Download file
    Given I go to sign in page
    When I login
    And I should see "salavatamingaliev" on profile page
    And I visit "yandexDrive" page
    And I download file with name "Lab6.pdf"
    And I logout
    Then I need to make sure that i downloaded the right file
