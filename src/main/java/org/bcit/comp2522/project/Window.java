package org.bcit.comp2522.project;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {
  ArrayList<Enemy> enemies;
  Bullet testBullet;
  Path path;
  Grid grid;
  // Variables for the timer
  int timeRegularEnemy = 0;
  int timeFastEnemy = 0;
  int timeBossEnemy = 0;

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
    grid = new Grid(this);
    testBullet = new Bullet(0, 200, this);
    enemies = new ArrayList<>();
    // Test for path
    path.addCorner(40,288);
    path.addCorner(184,288);
    path.addCorner(184,384);
    path.addCorner(472,384);
    path.addCorner(472,288);
    path.connectCorners();
    //testEnemy = new Enemy(path.getHead().getXpos(),path.getHead().getYpos(),this);

  }

  /**
   * Draws objects on the game window.
   */
  public void draw() {
    background(0);
    grid.draw();
    path.draw();
    testBullet.draw();

    // Update the timer
    timeRegularEnemy++;
    timeFastEnemy++;
    timeBossEnemy++;

    // Check if it's time to spawn a new regular enemy
    if (timeRegularEnemy >= 300) { // 300 frames = 5 seconds
      timeRegularEnemy = 0;
      enemies.add(new Enemy(path.getHead().getXpos(), path.getHead().getYpos(), this, 100, 2, 2));
    }

    // Check if it's time to spawn a new fast enemy
    if (timeFastEnemy >= 600) { // 600 frames = 10 seconds
      timeFastEnemy = 0;
      enemies.add(new Enemy(path.getHead().getXpos(), path.getHead().getYpos(), this, 100, 4, 4));
    }

    // Check if it's time to spawn a new boss enemy
    if (timeBossEnemy >= 900) { // 900 frames = 15 seconds
      timeBossEnemy = 0;
      enemies.add(new Enemy(path.getHead().getXpos(), path.getHead().getYpos(), this, 100, 1, 1));
    }

    // Update and draw the enemies
    for (Enemy enemy : enemies) {
      enemy.move();
      enemy.draw();
    }
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

//  public void removeEnemy(Enemy enemy) {
//  }
}
