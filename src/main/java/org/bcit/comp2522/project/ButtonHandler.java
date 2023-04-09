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
    Window window;

    Button button;



    public ButtonHandler(Button button){

        this.button = button;
        this.window = button.getParent();
    }

    public boolean checkHover(int mouseX, int mouseY){
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();
        int xRadius = width / 2;
        int yRadius = height / 2;


        return mouseX >= x - xRadius && mouseX <= x + xRadius &&
                mouseY >= y - yRadius && mouseY <= y + yRadius;


    }



    public void clickHandler(int mouseX, int mouseY){


        if (button.getFunction() == ButtonFunction.START && checkHover(mouseX, mouseY)){
            window.setStage(2);
        }
        if (button.getFunction() == ButtonFunction.HIGHSCORE && checkHover(mouseX, mouseY)){
            window.setStage(5);
        }

        if(button.getFunction() == ButtonFunction.LOAD && checkHover(mouseX, mouseY)) {
            window.setStage(2);
            Thread myThread = new Thread(() -> {
                StateManager sm = new StateManager(window, window.getLevelManager());
                sm.pull();
                sm.pullCoinsAndPoints();
            });
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("loading");



        }

    }


}
