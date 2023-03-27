package org.bcit.comp2522.project;

import processing.core.PApplet;

/**
 * Handles the interactions with menu items.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 *
 */
public class ButtonHandler {
    Window parent;

    Button button;

    public ButtonHandler(Button button){

        this.button = button;
    }

    public void startButtonPressed(){
        if (this.button.function == ButtonFunction.START){
            parent.setStage(2);
        }

    }


}
