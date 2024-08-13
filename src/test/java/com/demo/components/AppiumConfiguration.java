package com.demo.components;

import com.demo.init.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.ScreenOrientation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

//@Configuration
//@ComponentScan(basePackages = "com.demo")
@Component
public class AppiumConfiguration extends BaseTest {

    @Value("${platform}")
    private String platform;

    @Value("${appium.driver.headless}")
    private boolean headless;

    @Value("${android.app.path}")
    private String androidApp;

    @Value("${ios.package.path}")
    private String iOSApp;

    @Value("${ios.device.name}")
    private String iosDeviceName;

    @Value("${ios.platform.version}")
    private String iosPlatformVersion;

    @Value("${android.device.name}")
    private String androidDeviceName;

    @Value("${android.package}")
    private String androidPackage;

    @Value("${android.activity}")
    private String androidActivity;

    @Value("${android.platform.version}")
    private String androidPlatformVersion;

    @Value("${appium.noReset}")
    private Boolean noReset;

    private AppiumDriver driver;

    public AppiumConfiguration(){
    }


    public AppiumDriver startDriver(AppiumServer server, String deviceName, int driverPort) {
        AppiumDriverLocalService service = server.startServer(platform);
        if ("ios".equalsIgnoreCase(platform)){
            return createIOSDriver(service, deviceName, driverPort);
        }
        return createAndroidDriver(service, deviceName, driverPort);
    }

    private AppiumDriver createIOSDriver(AppiumDriverLocalService service, String deviceName, int driverPort) {
        final XCUITestOptions xcuiTestOptions = new XCUITestOptions()
                .setDeviceName(deviceName)
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setWdaLocalPort(driverPort)
                .setIsHeadless(false)
                .setNewCommandTimeout(Duration.ofSeconds(60))
                .setCommandTimeouts(Duration.ofSeconds(60))
                .setPlatformVersion(iosPlatformVersion)
                .setApp(iOSApp)
                .setOrientation(ScreenOrientation.PORTRAIT)
                .setNewCommandTimeout(Duration.ofSeconds(30))
                .setNoReset(false);
        driver = new IOSDriver(service.getUrl(), xcuiTestOptions);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }


    private AppiumDriver createAndroidDriver(AppiumDriverLocalService service, String deviceName, int driverPort) {
        final UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setAvd(deviceName)
                .setDeviceName(deviceName)
                .setSystemPort(driverPort)
                .setIsHeadless(false)
                .setAvdLaunchTimeout(Duration.ofSeconds(300))
                .setAvdReadyTimeout(Duration.ofSeconds(100))
                .setNewCommandTimeout(Duration.ofSeconds(30))
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setApp(androidApp)
                .setPlatformVersion(androidPlatformVersion)
                .setAppPackage(androidPackage)
                .setAppActivity(androidActivity)
                .setAutoGrantPermissions(true)
                .setNoReset(noReset);
        driver = new AndroidDriver(service.getUrl(), uiAutomator2Options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
        return driver;
    }


}
