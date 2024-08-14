package com.demo.init;

import com.demo.components.AppActions;
import com.demo.components.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public abstract class BaseTest {
    protected static final ThreadLocal<AppiumDriver> driverLocal = new ThreadLocal<>();

    protected Scenario scenario;

    protected static AppiumDriver driver;

    protected static AppActions app;

    public BaseTest() {
    }


    protected void setDriver(AppiumDriver driver, AppActions app) {
        BaseTest.driver = driver;
        BaseTest.app = app;
    }

    protected void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

}
