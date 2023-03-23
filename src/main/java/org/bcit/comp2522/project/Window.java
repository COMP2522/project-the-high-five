package org.bcit.comp2522.project;

import processing.core.PApplet;


public class Window extends PApplet {
  Enemy testEnemy;
  Enemy testEnemy2;
  Enemy testEnemy3;

  Bullet testBullet;

  Path path;
  public void setup() {
    this.init();
  }

  public void init(){
    path = new Path(this);
    testEnemy = new Enemy(0,180,this, 100, 1f,1f);
    testEnemy2 = new Enemy(0,180,this, 100, 2f,2f);
    testEnemy3 = new Enemy(0,180,this, 100, 3.25f,3.25f);
    testBullet = new Bullet(0,200,this);

  }
  public void draw() {
    background(0);
    path.draw();
    testEnemy.update();
    testEnemy2.update();
    testEnemy3.update();
    testEnemy.draw();
    testEnemy2.draw();
    testEnemy3.draw();
    testBullet.draw();
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
