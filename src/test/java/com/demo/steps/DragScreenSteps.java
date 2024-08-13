package com.demo.steps;

import com.demo.screen.DragScreen;
import io.cucumber.java.en.Given;

public class DragScreenSteps {

    DragScreen dragScreen;

    public DragScreenSteps() {
        dragScreen = new DragScreen();
    }

    @Given("drag image to target")
    public void hitLoginButton() {
        System.out.println("last: " + Thread.currentThread().getId());
        dragScreen.dragOne();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
