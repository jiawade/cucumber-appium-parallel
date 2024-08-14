package com.demo.init;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.demo.components.AppActions;
import com.demo.components.AppiumConfiguration;
import com.demo.components.AppiumServer;
import com.demo.plugin.ScenarioTracker;
import com.google.common.collect.Lists;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.*;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = AppiumConfiguration.class)
public class Hook  extends BaseTest{
    private static final ThreadLocal<AppiumServer> appiumServer = new ThreadLocal<>();
    private final List<String> devices = Lists.newArrayList("iPhone 14 Pro Max", "iPhone 14 Pro");
    private static final ThreadLocal<String> assignedDevice = new ThreadLocal<>();
    private static final AtomicInteger deviceIndex = new AtomicInteger(0);

    @Autowired
    public AppiumConfiguration app;



    @Before()
    public void setComponents(Scenario scenario) {
        if (assignedDevice.get() == null) {
            int index = deviceIndex.getAndIncrement() % devices.size();
            assignedDevice.set(devices.get(index));
        }

        if (appiumServer.get() == null) {
            appiumServer.set(new AppiumServer());
        }

        if (driverLocal.get() == null){
            driverLocal.set(app.startDriver(appiumServer.get(), assignedDevice.get(), this.findAvailablePort()));
        }

        driver = driverLocal.get();
        super.setDriver(driverLocal.get(), new AppActions(driverLocal.get()));
    }

    @After()
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            String png = driver.getScreenshotAs(OutputType.BASE64);
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(png).build());
        }

        List<String> lastScenarioName = ScenarioTracker.getInstance().getAllLastScenarioName();

        if (lastScenarioName.contains(scenario.getName())) {
            WebDriver driver = driverLocal.get();
            driver.quit();
            driverLocal.remove();
            appiumServer.remove();
        }
    }

    public int findAvailablePort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        } catch (IOException e) {
            throw new RuntimeException("No available port found", e);
        }
    }
}
