Feature: OTTWeb

  @Login
  Scenario: Login Demo
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username    | password |
      | 9100381062 | Password@123 |
    Then I click on Premium
    And Select "sonylive"
    Then select first show