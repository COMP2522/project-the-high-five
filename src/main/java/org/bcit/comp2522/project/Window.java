package org.bcit.comp2522.project;

import  java.util.ArrayList;

import org.w3c.dom.events.MouseEvent;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {

  public static final int windowWidth = 1280;
  public static final int windowHeight = 720;

  ArrayList<Enemy> enemies;
  Bullet testBullet;
  Path path;
  LevelManager levelManager;
  Level level_1;

  Level level_2;
  ArrayList<Tower> towers;
  EnemyManager enemyManager;
  Tower selectedTower = null;
  private static PImage background;


  private Menu menu;

  private int stage;

  ButtonHandler bh;

  // Variables for the timer
  int timeRegularEnemy = 0;
  int timeFastEnemy = 0;
  int timeBossEnemy = 0;

  Grid grid;

  /**
   * Sets up the game window and initializes objects.
   */
  public void setup() {
    stage = 1;
    menu = new Menu(this);
    this.init();

  }

  public void setStage(int stage) {
    this.stage = stage;
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
    enemyManager = new EnemyManager(this);

    timeRegularEnemy = 0;
    timeFastEnemy = 0;
    timeBossEnemy = 0;

    testBullet = new Bullet(0, 200, this);
    enemies = new ArrayList<>();
    towers = new ArrayList<>();
    // 5 towers have been spawned on top of each other
    // This is so the player can drag and drop them into desired spots
    // 5 is hardcoded number but would lke to personalize based on level.
    towers.add(new Tower(90, 630,this));
    towers.add(new Tower(190, 630,this));
    towers.add(new Tower(290, 630,this));
    towers.add(new Tower(390, 630,this));
    towers.add(new Tower(490, 630,this));
  }

  /**
   * Draws objects on the game window.
   */
  /**
   * Draws objects on the game window.
   */
  public void draw() {
    if (stage == 1) {
      menu.display();
    } else {
      background(0);
      path.draw();
      testBullet.draw();
      levelManager.draw();
      for (Tower tower : towers) {
        tower.draw();
      }

  }

  public void mousePressed() {
    if (stage == 1) {
      menu.mousePressed(mouseX, mouseY);
    } else {
      for (Tower tower : towers) {
        if (tower.isHovering()) {
          selectedTower = tower;
          selectedTower.mousePressed();
          break;
        }
      }
    }}
  }

  public void mouseDragged() {
    if (selectedTower != null) {
      selectedTower.mouseDragged();
    }
  }

  public void mouseReleased(){
    selectedTower.mouseReleased();
  }

  /**
   * Sets up the size of the game window.
   */
  public void settings() {
    size(windowWidth, windowHeight);
  }



public void keyPressed(){
    if (key == 'm' || key == 'M'){
      stage = 1;
      this.init();

    }

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
