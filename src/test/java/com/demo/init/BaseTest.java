package com.demo.init;

import com.demo.components.AppActions;
import com.demo.components.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseTest {

    protected Scenario scenario;

    public static AppiumServer server;

    protected static AppiumDriver driver;

    protected static AppActions app;

    public BaseTest() {
    }


    protected void setDriver(AppiumDriver driver, AppiumServer server, AppActions app) {
        BaseTest.server = server;
        BaseTest.driver = driver;
        this.app = app;
    }

    protected void setScenario(Scenario scenario) {
        this.scenario=scenario;
    }

}
