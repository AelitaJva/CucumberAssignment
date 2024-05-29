package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.util.Stack;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        ConfigReader.initProperties();
        DriverUtils.createDriver();
    }

}
