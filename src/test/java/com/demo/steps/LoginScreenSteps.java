package com.demo.steps;

import com.demo.screen.LoginScreen;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Value;

public class LoginScreenSteps {
    LoginScreen loginScreen;

    public LoginScreenSteps() {
        loginScreen = new LoginScreen();
    }


    @Value("${username}")
    private String userName;

    @Value("${password}")
    private String passWord;


    @Given("hit sign up tab")
    public void hitLoginButton() {
       loginScreen.hitSignUpTab();
    }

}
