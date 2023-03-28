package org.bcit.comp2522.project;

import  java.util.ArrayList;

import processing.core.PApplet;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {
  ArrayList<Enemy> enemies;
  Bullet testBullet;
  Path path;
  ArrayList<Tower> towers;
  EnemyManager enemyManager;

  // Variables for the timer
  int timeRegularEnemy = 0;
  int timeFastEnemy = 0;
  int timeBossEnemy = 0;

  /**
   * Sets up the game window and initializes objects.
   */
  Grid grid;
  public void setup() {
    this.init();
  }

  /**
   * Initializes objects.
   */
  public void init() {
    path = new Path(this);
    grid = new Grid(this);
    // Test for path
    path.addCorner(40,288);
    path.addCorner(184,288);
    path.addCorner(184,384);
    path.addCorner(472,384);
    path.addCorner(472,288);
    path.connectCorners();

    enemyManager = new EnemyManager(this);
    testBullet = new Bullet(0, 200, this);
    enemies = new ArrayList<>();
    towers = new ArrayList<>();
  }

  /**
   * Draws objects on the game window.
   */
  public void draw() {
    background(0);
    path.draw();
    testBullet.draw();


    // Update the timer
    timeRegularEnemy++;
    timeFastEnemy++;
    timeBossEnemy++;

    // Check if it's time to spawn a new regular enemy
    if (timeRegularEnemy >= 300) { // 300 frames = 5 seconds
      timeRegularEnemy = 0;
      enemies.add(new Enemy(path.getHead().getXpos(), path.getHead().getYpos(), this, 2, 2, 2, 50));
    }

    // Check if it's time to spawn a new fast enemy
    if (timeFastEnemy >= 600) { // 600 frames = 10 seconds
      timeFastEnemy = 0;
      enemies.add(new Enemy(path.getHead().getXpos(), path.getHead().getYpos(), this, 1, 4, 4,35));
    }

    // Check if it's time to spawn a new boss enemy
    if (timeBossEnemy >= 900) { // 900 frames = 15 seconds
      timeBossEnemy = 0;
      enemies.add(new Enemy(path.getHead().getXpos(), path.getHead().getYpos(), this, 4, 1, 1, 75));
    }

    // Update and draw the enemies
    for (Enemy enemy : enemies) {
        enemyManager.update(enemy);
    }

    grid.draw();

    // For now just hardcoded only 5 towers being made in fixed spots but would like to customize based on level
    towers.add(new Tower(200, 200,this));
    towers.add(new Tower(600, 350,this));
    towers.add(new Tower(700, 100,this));
    towers.add(new Tower(100, 10,this));
    towers.add(new Tower(400, 500,this));

    // draw the towers
    for (Tower tower : towers){
      tower.draw();
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
