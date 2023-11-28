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

  @sanity1
  Scenario: check all pages are opening
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

  @Sanity
  Scenario: Verify filters on searched page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And Search content "Jhalak dikhla jaa"
    Then click on see all result
    Then click on searchPage "Movie"
    And verify filters present
    Then click on searchPage "Show"
    And verify filters present
    Then click on searchPage "Stories"
    And verify filters present on stories page

  @Sanity
  Scenario: Verify filters on my profile
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    And verify filters on profile

  @Sanity
  Scenario: Verify filters for unsubscribed user
    Given I navigate to application
    And click on settings button
    And click and verify setting filters for unsubscribed user

  @Sanity
  Scenario: Verify filters on movie listing page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "More"
    Then click on "Movies" listing
    Then verify filters on listing page

  @Sanity
  Scenario: Verify filters on shows listing page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "More"
    Then click on "Shows" listing
    Then verify filters on listing page

  @Sanity
  Scenario: Verify filters for Streaming now page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Streaming Now"
    Then click on Movie releases
    Then change the language filter to hindi
    And verify filter applied for hindi language

  @sanity
  Scenario: check all pages are opening
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Live TV"
    And scroll to bottom of page
    Then I click on "Premium"
    And scroll to bottom of page
    Then I click on "Reviews"
    And scroll to bottom of page
    Then I click on "Web Stories"
    And scroll to bottom of page
    Then I click on "Photos"
    And scroll to bottom of page
