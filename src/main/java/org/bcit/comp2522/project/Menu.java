package org.bcit.comp2522.project;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import java.sql.SQLOutput;

public class Menu {

    private PApplet parent;
    private PImage backgroundImage;



    public Menu(PApplet parent){
        this.parent = parent;
        String dataPath = parent.sketchPath("images");
        this.backgroundImage = parent.loadImage(dataPath + "/laptop.jpg");

    }

    public void display() {

        PApplet p = parent;

        PFont gameFont;
        int horizontalPos = p.width/2;
        int startPos = p.height * 5 / 14;
        int loadPos = p.height * 8 / 14;
        int buttonWidth = 400;
        int buttonHeight = 100;

        p.image(backgroundImage, 0, 0, p.width, p.height);
        p.rectMode(p.CENTER);
        p.fill(0,0,0);
        p.rect(horizontalPos, startPos, buttonWidth,buttonHeight);
        p.rect(horizontalPos, loadPos, buttonWidth,buttonHeight);

        String dataPath = p.sketchPath("fonts");
        gameFont = p.createFont("" + dataPath + "/Righteous-Regular.ttf", 400);

        p.textFont(gameFont);
        p.fill(255);
        p.textSize(40);
        p.textAlign(parent.CENTER, parent.CENTER);
        p.text("START GAME",horizontalPos,startPos);
        p.text("LOAD GAME",horizontalPos,loadPos);




    }

}
