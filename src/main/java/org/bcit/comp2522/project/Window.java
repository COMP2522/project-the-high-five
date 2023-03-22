package org.bcit.comp2522.project;

import processing.core.PApplet;


public class Window extends PApplet {
  Enemy testEnemy;
  Path path;
  public void setup() {
    this.init();
  }

  public void init(){
    path = new Path(this);
    testEnemy = new Enemy(0,180,this);


  }
  public void draw() {
    background(0);
    path.draw();
    testEnemy.update();
    testEnemy.draw();
  }
  public void settings() {
    size(640,360);
  }

  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);
  }

}
