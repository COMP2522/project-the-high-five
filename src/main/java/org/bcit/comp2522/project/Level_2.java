package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_2 extends Level {
  Window window;

  EnemyManager enemyManager;
  private TileMap tileMap;
  private ArrayList<Tower> towers;
  private BulletManager bulletManager;

  int timeRegularEnemy;
  int timeFastEnemy;
  int timeBossEnemy;

  PImage tilemapImg;

  public Level_2(Window window) {
    super(window);
    this.window = window;
    tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
    init();
  }

  public void init(){
    towers = new ArrayList<>();
    tileMap = new TileMap(window, getPath(), towers, bulletManager);
    timeBossEnemy = 0;
    timeFastEnemy = 0;
    timeRegularEnemy = 0;
    enemyManager = new EnemyManager(window);

    getPath().clearCorner();
    getPath().addCorner(40, 384);
    getPath().addCorner(280, 384);
    getPath().addCorner(280, 528);
    getPath().addCorner(520, 528);
    getPath().addCorner(520, 96);
    getPath().addCorner(856, 96);
    getPath().addCorner(856, 288);
    getPath().addCorner(664, 288);
    getPath().addCorner(664, 432);
    getPath().addCorner(1192, 432);
    //getPath().addCorner(376,288);
    getPath().connectCorners();

    tileMap.setPath();
  }

  public void draw() {
    window.background(0);
    window.image(tilemapImg, 40, 0);
    getPath().draw();
    //System.out.println(getPath().getHead());
    //window.grid.draw();

    // Update the timer
    timeRegularEnemy++;
    timeFastEnemy++;
    timeBossEnemy++;

    // Check if it's time to spawn a new regular enemy
    if (timeRegularEnemy >= 400) { // 400 frames = 6.6 seconds
      timeRegularEnemy = 0;
      enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 2, this));
    }

    // Check if it's time to spawn a new fast enemy
    if (timeFastEnemy >= 500) { // 500 frames = 8 seconds
      timeFastEnemy = 0;
      enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4, 1, this));
    }

    // Check if it's time to spawn a new boss enemy
    if (timeBossEnemy >= 1200) { // 1200 frames = 20 seconds
      timeBossEnemy = 0;
      enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 3, this));
    }

    // Update and draw the enemies
    enemyManager.update();
    //window.grid.draw();
    //tileMap.checkMap();

  }
}
