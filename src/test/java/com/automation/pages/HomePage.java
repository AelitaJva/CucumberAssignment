package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h1[text()='Action Urgent Care']")
    WebElement homePageTitle;

    @FindBy(xpath = "//h1")
    WebElement pageHeading;

    @FindBy(xpath = "//a[text()='In-Clinic Care' and @class='dropdown-toggle nav-link']")
    WebElement inClinicCareDropdown;

    @FindBy(xpath = "//button[text()='Select']")
    WebElement appointmentSelectBtn;

    @FindBy(xpath = "//div[contains(@class,'css-tzs92q')]//p")
    List<WebElement> availableTimeList;

    @FindBy(xpath = "//p[text()='Reason for Consultation']")
    WebElement reasonForCancellationTitle;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement reasonForCancellationContinueBtn;

    @FindBy(xpath = "//div[contains(@class,'css-240zvz')]/following-sibling::span")
    WebElement reasonForCancellationErrorMsg;

    String reasonForConsultationXpath = "//button[text()='%s']";

    String inClinicCareDropdownOptionXpath = "//div[contains(@class,'dropdown-menu')]//a[text()='%s']";


    public boolean isHomePageDisplayed() {
        return homePageTitle.isDisplayed() && inClinicCareDropdown.isDisplayed();
    }

    public void openWebsite() {
        driver.get(ConfigReader.getProperty("application.url"));
    }


    public void selectInClinicCareOption(String dropdownOption) {
        String loc = String.format(inClinicCareDropdownOptionXpath, dropdownOption);
        Actions action = new Actions(driver);
        action.moveToElement(inClinicCareDropdown).pause(1000).click(driver.findElement(By.xpath(loc))).build().perform();
    }

    public String getPageHeading() {
        return pageHeading.getText();
    }

    public boolean isAppointmentSelectBtnDisabled() {
        return appointmentSelectBtn.isEnabled();
    }

    public void clickOnSelectBtn() {
        clickElementUsingJS(appointmentSelectBtn);
    }

    public boolean isReasonForConsultationSectionDisplayed() {
        return reasonForCancellationTitle.isDisplayed();
    }

    public void clickContinueFromReasonOfConsultationSection() {
        clickElementUsingJS(reasonForCancellationContinueBtn);
    }

    public String getErrorMsgForReasonForConsultation() {
        return reasonForCancellationErrorMsg.getText();
    }

    public void selectAnyAvailableTimeSlot() {
        clickElementUsingJS(availableTimeList.get(0));
    }

    public void selectReasonForConsultation(String reasonForConsultation) {
        String loc = String.format(reasonForConsultationXpath, reasonForConsultation);
        clickElementUsingJS(driver.findElement(By.xpath(loc)));
    }
}
