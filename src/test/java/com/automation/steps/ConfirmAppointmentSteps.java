package com.automation.steps;

import com.automation.pages.ConfirmAppointmentPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ConfirmAppointmentSteps {

    ConfirmAppointmentPage confirmAppointmentPage = new ConfirmAppointmentPage();

    @Then("verify Confirm Appointment page is displayed")
    public void verifyConfirmAppointmentPage() {
        Assert.assertTrue(confirmAppointmentPage.isConfirmAppointmentPageIsDisplayed());
    }
}
