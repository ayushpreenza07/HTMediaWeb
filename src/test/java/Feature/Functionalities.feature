Feature: OTT Play Functionalities

#  @Func1
#  Scenario: Verify Fast Forward
#    Given I navigate to application
#    When I click on Sign In button
#    And I enter username and password
#      | username   | password     |
#      | 9100381062 | Password@123 |
#    Then I click on Premium
#    And Select "sonylive"
#    Then select first show
#    And play the show
#    And click on fullscreen
#    And verify fast forward is working

  @Func2
  Scenario: Verify Next Page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on Premium
    And Select "sonylive"
    Then select first show
    And play the show
    And Get the title of show
    Then click on next episode
    Then verify user is on next page

  @Func3
  Scenario: Verify OTT Play Brand logo
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on Premium
    And Select "sonylive"
    Then select first show
    And play the show
    And verify ott play brand logo

  @Func4
  Scenario: Verify Seek bar
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on Premium
    And Select "sonylive"
    Then select first show
    And play the show
    And verify seek bar


  @Func5
  Scenario: Verify Back button
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on Premium
    And Select "sonylive"
    Then select first show
    And play the show
    Then verify back button