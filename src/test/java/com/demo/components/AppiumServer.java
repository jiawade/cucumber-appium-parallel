package com.demo.components;

import com.demo.exception.UnsupportedPlatformException;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.ALLOW_INSECURE;

public class AppiumServer {

    private AppiumDriverLocalService service;


    public AppiumDriverLocalService startServer(String platform) {
        final AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withArgument(BASEPATH,"/")
                .withArgument(SESSION_OVERRIDE)
                .withArgument(LOG_LEVEL, "error")
                .withArgument(ALLOW_INSECURE, "chromedriver_autodownload");
        if (platform.equalsIgnoreCase("android")) {
                    builder.withArgument(USE_DRIVERS, "uiautomator2");
        } else if (platform.equalsIgnoreCase("ios")) {
            builder.withArgument(USE_DRIVERS, "xcuitest");
        }else {
            throw new UnsupportedPlatformException("Unsupported platfrom: "+platform);
        }
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        return service;
    }

    public void stopServer() {
        service.stop();
    }

}
