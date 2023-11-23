Feature: Sanity Test cases

  @sanity
  Scenario: Check Login/Logout
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    And verify user able to logout

  @sanity
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

  @sanity
  Scenario: check facing issues play here link working in sony contents
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    Then verify facing issues play here link

  @sanity
  Scenario: Search any content,check all sections displaying search results
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And Search content "Jhalak dikhla jaa"
    Then click on see all result
    Then click on movies,shows,stories,live tv etc

  @sanity
  Scenario: Check all providers displaying data
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    Then click on "hallmarkmoviesnow" vendor
    Then select first show
    And Play show
    Then verify whether the episode is playing or not
    Then Pause episode
    Then click on show back button
    And I click on User icon
    Then click on "ptcplay" vendor
    Then select second show
    And Play show
    Then verify whether the episode is playing or not