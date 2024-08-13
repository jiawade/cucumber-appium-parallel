package com.demo.steps;

import com.demo.init.BaseTest;
import com.demo.screen.MainScreen;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainScreenSteps {
    MainScreen mainScreen;

    public MainScreenSteps(){
        mainScreen = new MainScreen();
    }

    @Given("hit login button on main screen")
    public void hitLoginButton() {
        mainScreen.hitLoginButton();
    }

    @Given("hit drag button on main screen")
    public void hitDragButton() {
        mainScreen.hitDragButton();
    }
}
