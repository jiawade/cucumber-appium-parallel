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

public class LoginScreen extends BaseTest {
    @AndroidFindBy(accessibility = "input-email")
    @iOSXCUITFindBy(accessibility = "input-email")
    private WebElement userNameBox;

    @AndroidFindBy(accessibility = "input-password")
    @iOSXCUITFindBy(accessibility = "input-password")
    private WebElement passWordBox;

    private final By signUpTab = AppiumBy.accessibilityId("button-sign-up-container");

    public LoginScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void enterUserName(String text) {
        app.send(this.userNameBox, text);
    }

    public void enterPassWord(String text) {
        app.send(this.passWordBox, text);
    }

    public void hitSignUpTab() {
        app.click(signUpTab);
    }

}
