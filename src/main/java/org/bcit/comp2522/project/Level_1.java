package org.bcit.comp2522.project;

import processing.core.PImage;

public class Level_1 extends Level{
  Window window;

  EnemyManager enemyManager;
  PImage tilemapImg;
  private TileMap tileMap;
  int timeRegularEnemy;
  int timeFastEnemy;
  int timeBossEnemy;
  public Level_1(Window window){
    super(window);
    this.window = window;
    init();
  }

  public void init(){
    tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
    timeBossEnemy = 0;
    timeFastEnemy = 0;
    timeRegularEnemy = 0;
    enemyManager = new EnemyManager(window);
    tileMap = new TileMap(window, getPath());
    getPath().clearCorner();
    getPath().addCorner(40, 384);
    getPath().addCorner(376, 384);
    getPath().addCorner(376, 192);
    getPath().addCorner(760, 192);
    getPath().addCorner(760, 384);
    getPath().addCorner(1192, 384);
    getPath().connectCorners();
    tileMap.setPath();
  }

  public void draw(){
    window.background(0);
    window.image(tilemapImg, 40, 0);
    getPath().draw();
    if (window.enemies.size() > 0) {
      window.testBullet.move();
    }
    window.testBullet.draw();

    // Update the timer
    timeRegularEnemy++;
    timeFastEnemy++;
    timeBossEnemy++;

    // Check if it's time to spawn a new regular enemy
    if (timeRegularEnemy >= 300) { // 300 frames = 5 seconds
      timeRegularEnemy = 0;
      enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 50, this));
    }

    // Check if it's time to spawn a new fast enemy
    if (timeFastEnemy >= 600) { // 600 frames = 10 seconds
      timeFastEnemy = 0;
      enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4,35, this));
    }

    // Check if it's time to spawn a new boss enemy
    if (timeBossEnemy >= 900) { // 900 frames = 15 seconds
      timeBossEnemy = 0;
      enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 75, this));
    }

    // Update and draw the enemies
    enemyManager.update();
    //window.grid.draw();
    //tileMap.checkMap();

  }
}
