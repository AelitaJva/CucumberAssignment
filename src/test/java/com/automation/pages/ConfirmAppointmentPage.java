package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmAppointmentPage extends BasePage {
    @FindBy(xpath = "//p[text()='Confirm Appointment']")
    WebElement confirmAppointmentPageTitle;

    public boolean isConfirmAppointmentPageIsDisplayed() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
                break;
            }
        }
        return confirmAppointmentPageTitle.isDisplayed();
    }
}
