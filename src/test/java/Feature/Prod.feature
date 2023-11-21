Feature: Prod Test cases

  @Prod
  Scenario: Verify Live News, Sports, Entertainment channels Live Music, Regional, Spiritual on Live Tv
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |

  @prod1
  Scenario: Verify Parental control
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    Then verify Parental control is present

  @prod
  Scenario: verify Ott Subscribed channel rail
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    Then verify Ott channels rail