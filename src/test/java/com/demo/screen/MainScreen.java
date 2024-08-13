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
import org.springframework.stereotype.Component;

public class MainScreen extends BaseTest {

    @AndroidFindBy(accessibility = "Login")
    @iOSXCUITFindBy(accessibility = "Login")
    private final By loginButton = AppiumBy.accessibilityId("Login");

    private final By homeButton = AppiumBy.accessibilityId("Home");

    @AndroidFindBy(accessibility = "Webview")
    @iOSXCUITFindBy(accessibility = "Webview")
    private WebElement webviewButton;

    @AndroidFindBy(accessibility = "Forms")
    @iOSXCUITFindBy(accessibility = "Forms")
    private WebElement formsButton;

    @AndroidFindBy(accessibility = "Swipe")
    @iOSXCUITFindBy(accessibility = "Swipe")
    private WebElement swipeButton;

    private final By dragButton = AppiumBy.accessibilityId("Drag");


    public MainScreen() {
    }


    public void hitLoginButton() {
        app.click(AppiumBy.accessibilityId("Login"));
    }

    public void hitHomeButton() {
        app.click(this.homeButton);
    }

    public void hitDragButton() {
        app.click(this.dragButton);
    }

    public void hitformsButton() {
        app.click(this.formsButton);
    }

    public void hitswipeButton() {
        app.click(this.swipeButton);
    }

    public void hitWebviewButton() {
        app.click(this.webviewButton);
    }

}
