Feature: OTT Play Mobile Browser

  @mobile
  Scenario: Check mweb login/logout and login via social media
    Given launch in mobile browser
    Then click on user button
    And click login
    And I enter username and password in mobile
      | username   | password     |
      | 9100381062 | Password@123 |
    And click on sidebar
    Then click user profile
    And logout the user