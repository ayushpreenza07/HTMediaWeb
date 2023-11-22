Feature: Sanity Test cases

  @Sanity
  Scenario: Check Login/Logout
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    And verify user able to logout

  @Sanity
  Scenario: Play movie/show of sony,zee,lionsgate and shemaroo etc
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    Then click on "sonylive" vendor
    Then select first show
    And Play show
    Then verify whether the episode is playing or not
    Then Pause episode
    Then click on show back button
    And I click on User icon
    Then click on "shemaroo" vendor
    Then select second show
    And Play show
    Then verify whether the episode is playing or not