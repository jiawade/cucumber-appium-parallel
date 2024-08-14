package com.demo.steps;

import com.demo.screen.SignUpScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpScreenSteps {

    SignUpScreen signUpScreen;

    public SignUpScreenSteps() {
        signUpScreen = new SignUpScreen();
    }


    @Given("fill in account info")
    public void hitLoginButton() {
        for (int i =0; i<12;i++){
            signUpScreen.enterUserName("abc@123.com");
            signUpScreen.enterPassWord("11111111");
            signUpScreen.enterRepeatPassWord("11111111");
        }

    }

    @When("hit sign up button")
    public void hitSignUpButton(){
        signUpScreen.hitSignUpButton();
    }

    @Then("successfully sign up a account")
    public void verifyAccountHasBeenCreated(){
        signUpScreen.verifySignUpSuccess();
    }

}
