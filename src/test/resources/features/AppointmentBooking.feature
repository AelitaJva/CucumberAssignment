Feature: Order Confirmation Tests

  @Smoke
  Scenario: Verify Select button is disabled by default on select appointment time section
    Given user open website
    Then verify user is on home page
    And select "San Jose - Blossom Hill Rd." from in clinic care options
    Then verify chosen location is displayed on the page
    And verify select button is disabled on the Calendar Selection


  @Smoke
  Scenario: Verify error message for continuing without selecting reason for consulation
    Given user open website
    Then verify user is on home page
    And select "San Jose - Blossom Hill Rd." from in clinic care options
    Then verify chosen location is displayed on the page
    When user select any available appointment time
    And click on select button
    Then verify reason for consultation section is displayed
    When user click on continue button for reason for consultation section
    Then verify error message "Please enter reason for visit" is displayed

  @Smoke
  Scenario: Verify user can book an appointment
    Given user open website
    Then verify user is on home page
    And select "San Jose - Blossom Hill Rd." from in clinic care options
    Then verify chosen location is displayed on the page
    When user select any available appointment time
    And click on select button
    Then verify reason for consultation section is displayed
    When user select reason for consultation "Cough"
    And user click on continue button for reason for consultation section
    Then verify Confirm Appointment page is displayed
