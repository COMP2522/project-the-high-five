package org.bcit.comp2522.project;

import  java.util.ArrayList;

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
  ArrayList<Bullet> bullets;
  BulletManager bulletManager;

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

  private ButtonHandler bh;

  // Variables for the timer
  int timeRegularEnemy = 0;
  int timeFastEnemy = 0;
  int timeBossEnemy = 0;

  Grid grid;

  /**
   * Sets up the game window and initializes objects.
   */
  public void setup() {
    Player.getInstance();
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
    bulletManager = new BulletManager(this);
    // array of bullets
    bullets = new ArrayList<>();

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
    switch (stage) {
      case 1:
        menu.display();
        break;
      case 2:
        //background(0);
        //path.draw();
        //testBullet.draw();
        levelManager.draw();
        for (Tower tower : towers) {
          tower.draw();
        }

        // draw bullets
        for (Bullet bullet : bullets) {
          bullet.draw();
          bullet.move();
        }
        break;
      case 3:
        LosingScreen ls = new LosingScreen(this);
        ls.display();
        break;
      case 4:
        WinningScreen ws = new WinningScreen(this);
        ws.display();
        break;

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
      // makes sure game doesn't crash when tower isn't clicked
      if (selectedTower == null) {
        return;
      }
    }
  }

  public void mouseDragged() {
    if (selectedTower != null) {
      selectedTower.mouseDragged();
    }
  }

  private void spawnBullet(float x, float y) {
    if (!enemies.isEmpty()) {
//      Enemy nearestEnemy = enemies.get(0);
//      float minDist = dist(x, y, nearestEnemy.getXpos(), nearestEnemy.getYpos());
//
//      for (Enemy enemy : enemies) {
//        float curDist = dist(x, y, enemy.getXpos(), enemy.getYpos());
//        if (curDist < minDist) {
//          nearestEnemy = enemy;
//          minDist = curDist;
//        }
//      }

      Bullet newBullet = new Bullet(x, y, this);
      newBullet.setTarget(newBullet.window.enemies.get(newBullet.track()));
      bullets.add(newBullet);
    }
  }

  public void mouseReleased() {
    if (selectedTower != null) {
      spawnBullet(selectedTower.getXpos(), selectedTower.getYpos());
      selectedTower.mouseReleased();
      selectedTower = null;
    }
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

      if (key == 'w' || key == 'W') {
        levelManager.killEnemies();
      }

      if (key == 'l' || key == 'L') {
        levelManager.killPlayer();
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

//  public void removeBullet(Bullet bullet) {
//    if (bullet.collide()) {
//      bullets.remove(bullet);
//    }
//  }
}
