package com.automation.pages;

import com.automation.utils.DriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class BasePage {

    WebDriver driver = DriverUtils.getDriver();

    public BasePage(){
         PageFactory.initElements(driver, this);
    }

    public void clickElementUsingJS(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
