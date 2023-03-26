package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PImage;

public class Menu {

    private PApplet parent;
    private PImage backgroundImage;

    public Menu(PApplet parent){
        this.parent = parent;
        String dataPath = parent.sketchPath("images");
        this.backgroundImage = parent.loadImage(dataPath + "/laptop.jpg");

    }

    public void display() {
        parent.image(backgroundImage, 0, 0, parent.width, parent.height);
    }

}
