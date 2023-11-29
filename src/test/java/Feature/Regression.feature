Feature: Regression test cases

  Scenario:  Login with password
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And verify user is logged in

  Scenario: Login/Logout
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    And verify user able to logout

  Scenario: Check all pages are opening in header and bottom
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Live TV"
    Then I click on "Premium"
    Then I click on "Streaming Now"
    Then I click on "News"
    Then I click on "Reviews"
    Then I click on "Web Stories"
    Then I click on "Photos"
    Then I click on "More"