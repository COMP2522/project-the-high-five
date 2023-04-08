package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_3 extends Level {
  TowerManager towerManager;


  public Level_3(Window window) {
    super(window);
    init();
  }

  public void init() {
    levelreset();
    towerManager = new TowerManager(window);
    //levelManager = new LevelManager(window, 5);
    setTimeRegularEnemy(0);
    setTimeFastEnemy(0);
    setTimeBossEnemy(0);
    getPath().clearCorner();
    getPath().addCorner(40, 528);
    getPath().addCorner(232, 528);
    getPath().addCorner(232, 336);
    getPath().addCorner(472, 336);
    getPath().addCorner(472, 144);
    getPath().addCorner(808, 144);
    getPath().addCorner(808, 432);
    getPath().addCorner(664, 432);
    getPath().addCorner(664, 288);
    getPath().addCorner(1000, 288);
    getPath().addCorner(1000, 144);
    getPath().addCorner(1232, 144);

    getPath().connectCorners();
    getTileMap().setPath();
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
      towerManager.draw();
    }

    // Update the timer
    increaseTimeRegularEnemy(1);
    increaseTimeFastEnemy(1);
    increaseTimeBossEnemy(1);

    // Check if it's time to spawn a new regular enemy
    if (getTimeRegularEnemy() >= 350) { // 350 frames = 5.8 seconds
      setTimeRegularEnemy(0);
      getEnemyManager().addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 2, 2, 2, 2, this));
    }

    // Check if it's time to spawn a new fast enemy
    if (getTimeFastEnemy() >= 550) { // 550 frames = 9.2 seconds
      setTimeFastEnemy(0);
      getEnemyManager().addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 1, 4, 4, 1, this));
    }

    // Check if it's time to spawn a new boss enemy
    if (getTimeBossEnemy() >= 1000) { // 1000 frames = 16.7 seconds
      setTimeBossEnemy(0);
      getEnemyManager().addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 4, 1, 1, 3, this));
    }

    // towerMethods
    towerManager.shoot(enemyManager);
    towerManager.inRange();

    getBulletManager().update();
    getEnemyManager().update(getBulletManager());
    getWindow().grid.draw();
    //tileMap.checkMap();

  }
}
