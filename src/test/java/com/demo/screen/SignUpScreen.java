package com.demo.screen;

import com.demo.components.AppActions;
import com.demo.init.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

//@Component
public class SignUpScreen extends BaseTest {
    private final By userNameBox = AppiumBy.accessibilityId("input-email");

//    @AndroidFindBy(accessibility = "input-password")
//    @iOSXCUITFindBy(accessibility = "input-password")
    private final By passWordBox = AppiumBy.accessibilityId("input-password");

//    @AndroidFindBy(accessibility = "input-repeat-password")
//    @iOSXCUITFindBy(accessibility = "input-repeat-password")
    private final By repeatPassWordBox = AppiumBy.accessibilityId("input-repeat-password");

//    @AndroidFindBy(accessibility = "button-SIGN UP")
//    @iOSXCUITFindBy(accessibility = "button-SIGN UP")
    private final By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");

//    @AndroidFindBy(id = "android:id/message")
//    @iOSXCUITFindBy(accessibility = "You successfully signed up!")
    private final By sucessText = AppiumBy.accessibilityId("You successfully signed up!");

    AppActions app;


    public SignUpScreen() {
        app = new AppActions(driverLocal.get());
    }


    public void enterUserName(String text) {
        app.clear(this.userNameBox);
        app.send(this.userNameBox, text);
    }

    public void enterPassWord(String text) {
        app.clear(this.passWordBox);
        app.send(this.passWordBox, text);
    }

    public void enterRepeatPassWord(String text) {
        app.clear(this.repeatPassWordBox);
        app.send(this.repeatPassWordBox, text);
    }

    public void hitSignUpButton() {
        app.click(signUpButton);
    }

    public void verifySignUpSuccess() {
        Assert.assertEquals("You successfully signed up!", app.waitDisplay(this.sucessText).getText());
    }

}
