package org.bcit.comp2522.project;

import  java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {
  ArrayList<Enemy> enemies;
  Bullet testBullet;
  Path path;
  LevelManager levelManager;
  Level level_1;

  Level level_2;
  ArrayList<Tower> towers;
  private static PImage background;

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
    background = this.loadImage("src/main/java/org/bcit/comp2522/project/asset/BackDrop.png");
    levelManager = new LevelManager(this, 2);
    level_1 = new Level_1(this);
    level_2 = new Level_2(this);
    grid = new Grid(this);
    levelManager.addLevel(level_1);
    levelManager.addLevel(level_2);
    testBullet = new Bullet(0, 200, this);
    enemies = new ArrayList<>();
    towers = new ArrayList<>();
  }

  /**
   * Draws objects on the game window.
   */
  public void draw() {
    levelManager.draw();
  }

  /**
   * Sets up the size of the game window.
   */
  public void settings() {
    size(1280, 720);
  }

  public void keyPressed() {
    if (key == 'z' || key == 'Z') {
      levelManager.nextLevel();
    }
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
