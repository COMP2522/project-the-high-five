package org.bcit.comp2522.project;

import processing.core.PFont;

/**
 * Displays Losing screen
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class LosingScreen {
    private Window parent;

    public LosingScreen(Window parent){
        this.parent = parent;
    }

    public void display(){
        PFont gameFont;
        String dataPath = parent.sketchPath("fonts");
        gameFont = parent.createFont("" + dataPath + "/Righteous-Regular.ttf", 400);
        parent.textFont(gameFont);
        parent.background(0);
        parent.textSize(50);
        parent.textAlign(parent.CENTER, parent.CENTER);
        parent.text("OH NO\nYOU LOST  :( " +
                "\nYour score was :" + Player.getCurrentScore(), Window.windowWidth/2, Window.windowHeight/2);
    }


}
