Feature: Prod Test cases

  @Prod
  Scenario: Verify Live News, Sports, Entertainment channels, Live Music, Regional, Spiritual on Live Tv
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Live TV"
    And Verify Live News, Sports, Entertainment channels, Live Music, Regional, Spiritual on Live Tv

  @Prod
  Scenario: Verify Live TV Tamil and Telugu
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And enter "Tamil" in search box
    Then click on searchPage "Live TV"
    And Verify Live TV Tamil and Telugu

  @Prod
  Scenario: Setting page should be checked
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then click on profile Icon
    And verify Settings are present