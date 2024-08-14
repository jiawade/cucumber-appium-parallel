package com.demo.screen;

import com.demo.components.AppActions;
import com.demo.init.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class DragScreen extends BaseTest {
    private final By drag1 = AppiumBy.accessibilityId("drag-l2");

    private final By drop1 = AppiumBy.accessibilityId("drop-l2");

    AppActions app;


    public DragScreen() {
        app = new AppActions(driverLocal.get());
    }

    public void dragOne() {
        app.dragAndDrop(this.drag1, this.drop1);
    }

}
