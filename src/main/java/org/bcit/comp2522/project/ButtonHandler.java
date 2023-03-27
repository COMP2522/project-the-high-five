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
        this.parent = button.getParent();
    }

    public boolean checkHover(){
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();



        return parent.mouseX >= x && parent.mouseX <= x + width &&
                parent.mouseY >= y && parent.mouseY <= y + height;
    }



    public void clickHandler(){

        if (button.getFunction() == ButtonFunction.START && checkHover()){

            parent.setStage(2);
        }

    }


}
