package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;


/**
 * Displays Menu screen
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Menu {

    private Window parent;
    private PImage backgroundImage;



    public Menu(Window parent){
        this.parent = parent;
        String dataPath = parent.sketchPath("images");
        this.backgroundImage = parent.loadImage(dataPath + "/laptop.jpg");

    }

    public void display() {

        parent.image(backgroundImage, 0, 0, parent.width, parent.height);

        int horizontalPos = parent.width/2;

        Button startButton = new Button(parent, "START GAME", ButtonFunction.START, horizontalPos, parent.height * 5 / 14);
        Button loadButton = new Button(parent, "LOAD GAME", ButtonFunction.LOAD, horizontalPos, parent.height * 8 / 14);

        startButton.displayButton();
        loadButton.displayButton();

    }

}
