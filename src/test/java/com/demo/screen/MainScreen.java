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

@Component
//@Scope for not singleton use
public class MainScreen extends BaseTest {

    @AndroidFindBy(accessibility = "Login")
    @iOSXCUITFindBy(accessibility = "Login")
    private WebElement loginButton;

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

    @AndroidFindBy(accessibility = "Drag")
    @iOSXCUITFindBy(accessibility = "Drag")
    private WebElement dragButton;


    public MainScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }


    public void hitLoginButton() {
        System.out.println(app.isElementExist(this.loginButton));
        app.click(this.loginButton);
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
