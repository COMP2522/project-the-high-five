package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * Display buttons class for Menu options
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Button {

    Window parent;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * x-coordinate of button on the screen
     */
    private int x;

    /**
     * y-coordindate of button the screen
     */
    private int y;

    ButtonFunction function;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Button(Window parent, String text, ButtonFunction function, int x, int y){
        this.parent = parent;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void menuButtonShape(){
        int buttonWidth = 400;
        int buttonHeight = 100;
        parent.rectMode(parent.CENTER);
        parent.fill(0,0,0);
        parent.rect(this.x, this.y, buttonWidth,buttonHeight);
    }

    public void menuButtonText(){
        PFont gameFont;
        String dataPath = parent.sketchPath("fonts");
        gameFont = parent.createFont("" + dataPath + "/Righteous-Regular.ttf", 400);
        parent.textFont(gameFont);
        parent.fill(255);
        parent.textSize(40);
        parent.textAlign(parent.CENTER, parent.CENTER);
        parent.text(this.text, this.x, this.y);
    }

    public void displayButton(){
        menuButtonShape();
        menuButtonText();
    }
}
