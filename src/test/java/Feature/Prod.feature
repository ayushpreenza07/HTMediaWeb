Feature: Prod Test cases

  @Prod
  Scenario: Verify Live News, Sports, Entertainment channels Live Music, Regional, Spiritual on Live Tv
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |