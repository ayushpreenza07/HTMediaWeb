Feature: OTTWeb

  @sonyliv
  Scenario: Sony LIV
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on Premium
    And Select "SonyLIV"
    Then select first show
    And Play show
    Then Go full screen
    Then verify whether the episode is playing or not
    Then verify fast forward is working
    Then verify backward functionality
    And Verify whether the episode is paused on pausing it

    @prod
    Scenario: Prod TestCases
      Given I navigate to application
      When I click on Sign In button
      And I enter username and password
        | username   | password     |
        | 9100381062 | Password@123 |
      And I click on User icon
      Then verify Parental control is present

    @prod1
    Scenario: Prod TestCases
      Given I navigate to application
      When I click on Sign In button
      And I enter username and password
        | username   | password     |
        | 9100381062 | Password@123 |
      Then I click on Premium
      Then verify Ott channels rail


