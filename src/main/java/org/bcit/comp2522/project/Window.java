package org.bcit.comp2522.project;

import processing.core.PApplet;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {
  Enemy testEnemy1;
  Enemy testEnemy2;
  Enemy testEnemy3;
  Bullet testBullet;
  Path path;

  /**
   * Sets up the game window and initializes objects.
   */
  public void setup() {
    this.init();
  }

  /**
   * Initializes objects.
   */
  public void init() {
    path = new Path(this);
    testEnemy1 = new Enemy(0, 180, this, 100, 1, 1);
    testEnemy2 = new Enemy(0, 180, this, 100, 2, 2);
    testEnemy3 = new Enemy(0, 180, this, 100, 4, 4);
    testBullet = new Bullet(0, 200, this);

  }

  /**
   * Draws objects on the game window.
   */
  public void draw() {
    background(0);
    path.draw();
    testEnemy1.update();
    testEnemy2.update();
    testEnemy3.update();
    testEnemy1.draw();
    testEnemy2.draw();
    testEnemy3.draw();
    testBullet.draw();
  }

  /**
   * Sets up the size of the game window.
   */
  public void settings() {
    size(1280, 720);
  }

  /**
   * Main method that runs the game.
   *
   * @param passedArgs command line arguments
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);
  }
}
