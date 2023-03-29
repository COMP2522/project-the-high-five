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

    public boolean checkHover(int mouseX, int mouseY){
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();




        return mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;
    }



    public void clickHandler(int mouseX, int mouseY){
//        System.out.println("entered");
//        System.out.println(checkHover(mouseX, mouseY));

        if (button.getFunction() == ButtonFunction.START && checkHover(mouseX, mouseY)){
            System.out.println("clicked");
            parent.setStage(2);
        }

    }


}
