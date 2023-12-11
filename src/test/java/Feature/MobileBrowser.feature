Feature: OTT Play Mobile Browser

  @mobile
  Scenario: Check mweb login/logout and login via social media
    Given launch in mobile browser
    Then click on user button
    And click login
#    And I enter username and password in mobile
#      | username   | password     |
#      | 9100381062 | Password@123 |
#    And click on sidebar
#    Then click user profile
#    And logout the user
#    Then click on user button
#    And click login
    And click Sign in with Google
    Then verify google login page
    Then navigate back
    And click Sign in with Facebook
    Then verify facebook login page
    Then navigate back
    And click Sign in with Apple
    Then verify apple login page

    Scenario: Check Mweb all pages are opening nothing is breaking>>refresh and check sidebar will be displayed
