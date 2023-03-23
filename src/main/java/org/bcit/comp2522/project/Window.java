package org.bcit.comp2522.project;

import processing.core.PApplet;


public class Window extends PApplet {
  Enemy testEnemy;
  Path path;
  Grid grid;
  public void setup() {
    this.init();
  }

  public void init(){
    path = new Path(this);
    grid = new Grid(this);
    // Test for path
    path.addCorner(40,288);
    path.addCorner(184,288);
    path.addCorner(184,384);
    path.addCorner(472,384);
    path.addCorner(472,288);
    path.connectCorners();
    testEnemy = new Enemy(path.getHead().getXpos(),path.getHead().getYpos(),this);


  }
  public void draw() {
    background(0);

    path.draw();
    testEnemy.update();
    testEnemy.draw();
    grid.draw();
  }
  public void settings() {
    size(1280,720);
  }

  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);
  }

}
