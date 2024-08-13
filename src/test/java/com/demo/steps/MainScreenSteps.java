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
        System.out.println("hit login button on main screen: "+Thread.currentThread().getId());
        mainScreen.hitLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("hit drag button on main screen")
    public void hitDragButton() {
        mainScreen.hitDragButton();
    }
}
