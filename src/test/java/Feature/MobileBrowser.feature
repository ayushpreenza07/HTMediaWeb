Feature: OTT Play Mobile Browser

  @mobile
  Scenario: First testcase of mobile browser
    Given launch in mobile browser
    Then click on user button
    And click login
    And I enter username and password in mobile
      | username   | password     |
      | 9100381062 | Password@123 |