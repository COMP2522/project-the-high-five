package org.bcit.comp2522.project;

import processing.core.PApplet;


public class Window extends PApplet {


  public void settings() {
    size(640,360);
  }

  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);
  }

}
