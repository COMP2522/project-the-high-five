package org.bcit.comp2522.project;

import processing.core.PFont;

public class WinningScreen {

    private Window parent;

    public WinningScreen(Window parent){
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
        parent.text("YAY YOU WON!   :) " +
                "\nYour score was: " + Player.getCurrentScore(), Window.windowWidth/2, Window.windowHeight/2);
    }
}
