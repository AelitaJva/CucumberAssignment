package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();
    static String inClinicCareLocation;

    @Given("user open website")
    public void user_open_website() {
        homePage.openWebsite();
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("select {string} from in clinic care options")
    public void select_from_in_clinic_care_options(String dropdownOption) {
        homePage.selectInClinicCareOption(dropdownOption);
        inClinicCareLocation = dropdownOption;
    }

    @Then("verify chosen location is displayed on the page")
    public void verify_chosen_location_is_displayed_on_the_page() {
        Assert.assertEquals(inClinicCareLocation, homePage.getPageHeading());
    }

    @Then("verify select button is disabled on the Calendar Selection")
    public void verify_select_button_is_disabled_on_the_calendar_selection() {
        Assert.assertTrue(!homePage.isAppointmentSelectBtnDisabled());
    }

    @When("user select any available appointment time")
    public void user_select_any_available_appointment_time() {
        homePage.selectAnyAvailableTimeSlot();
    }

    @When("click on select button")
    public void click_on_select_button() {
        homePage.clickOnSelectBtn();
    }

    @Then("verify reason for consultation section is displayed")
    public void verify_reason_for_consultation_section_is_displayed() {
        Assert.assertTrue(homePage.isReasonForConsultationSectionDisplayed());
    }

    @When("user click on continue button for reason for consultation section")
    public void user_click_on_continue_button_for_reason_for_consultation_section() {
        homePage.clickContinueFromReasonOfConsultationSection();
    }

    @Then("verify error message {string} is displayed")
    public void verify_error_message_is_displayed(String errorMsg) {
        Assert.assertEquals(errorMsg, homePage.getErrorMsgForReasonForConsultation());
    }

    @When("user select reason for consultation {string}")
    public void userSelectReasonForConsultation(String reasonForConsultation) {
        homePage.selectReasonForConsultation(reasonForConsultation);
    }
}
