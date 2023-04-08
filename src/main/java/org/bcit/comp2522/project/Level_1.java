package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_1 extends Level {

  //SelectTowerUI selectTowerUI;


  public Level_1(Window window) {
    super(window);

    init();
  }

  public void init() {
//    tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
//    enemyManager = new EnemyManager(window);
//    towers = new ArrayList<>();
//    bulletManager = new BulletManager(window);
//    tileMap = new TileMap(window, getPath(), towers, bulletManager);
    levelreset();
//    setTimeRegularEnemy(0);
//    setTimeFastEnemy(0);
//    setTimeBossEnemy(0);
    getPath().clearCorner();
    getPath().addCorner(40, 384);
    getPath().addCorner(376, 384);
    getPath().addCorner(376, 192);
    getPath().addCorner(760, 192);
    getPath().addCorner(760, 384);
    getPath().addCorner(1192, 384);
    getPath().connectCorners();
    getTileMap().setPath();
    //selectTowerUI = new SelectTowerUI(getWindow(), getTileMap());
  }

  public void draw() {
    if (Player.getHealth() <= 0) {
      getWindow().setStage(3);

    } else {
      if (super.numEnemies <= 0) {
        getWindow().setStage(4);
      }
      getWindow().background(0);
      getWindow().image(getTilemapImg(), 40, 0);
      getPath().draw();
      getSelectTowerUI().draw();
      getSelectTowerUI().selectTower();
      getSelectTowerUI().slotClicked();
      getTowerManager().draw();

      // Update the timer
      increaseTimeRegularEnemy(1);
      increaseTimeFastEnemy(1);
      increaseTimeBossEnemy(1);
      System.out.println("Time Regular Enemy: " + getTimeRegularEnemy());
      //levelManager.setTimeFastEnemy(levelManager.getTimeFastEnemy() + 1);
      //levelManager.setTimeBossEnemy(levelManager.getTimeBossEnemy() + 1);

      // Check if it's time to spawn a new regular enemy
      if (getTimeRegularEnemy() >= 300) { // 300 frames = 5 seconds
        setTimeRegularEnemy(0);
        getEnemyManager().addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 2, 2, 2, 2, this));
      }

      // Check if it's time to spawn a new fast enemy
      if (getTimeFastEnemy() >= 600) { // 600 frames = 10 seconds
        setTimeFastEnemy(0);
        getEnemyManager().addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 1, 4, 4, 1, this));
      }

      // Check if it's time to spawn a new boss enemy
      if (getTimeBossEnemy() >= 900) { // 900 frames = 15 seconds
        setTimeBossEnemy(0);
        getEnemyManager().addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 4, 1, 1, 3, this));
      }

      // towerMethods
      getTowerManager().shoot(getEnemyManager());
      getTowerManager().inRange();


      // update and draw bullets
      getBulletManager().update();
      getEnemyManager().update(getBulletManager());
      //getWindow().grid.draw();
    }
  }
}
