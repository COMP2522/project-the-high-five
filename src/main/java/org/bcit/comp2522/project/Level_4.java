package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_4 extends Level {
    TowerManager towerManager;


    public Level_4(Window window) {
        super(window);
        init();
    }

    public void init() {
        levelreset();
        //levelManager = new LevelManager(window, 5);
        towerManager = new TowerManager(window);
        getPath().clearCorner();
        getPath().addCorner(40, 336);
        getPath().addCorner(520, 336);
        getPath().addCorner(520, 96);
        getPath().addCorner(808, 96);
        getPath().addCorner(808, 240);
        getPath().addCorner(952, 240);
        getPath().addCorner(952, 48);
        getPath().addCorner(1144, 48);
        getPath().addCorner(1144, 432);
        getPath().addCorner(1144, 528);
        getPath().addCorner(1144, 624);
        getPath().addCorner(808, 624);
        getPath().addCorner(808, 432);
        getPath().addCorner(1232, 432);

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
        if (getTimeRegularEnemy() >= 300) { // 300 frames = 5 seconds
            setTimeRegularEnemy(0);
            getEnemyManager().addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 2, 2, 2, 2, this));
        }

        // Check if it's time to spawn a new fast enemy
        if (getTimeFastEnemy() >= 450) { // 450 frames = 7.5 seconds
            setTimeFastEnemy(0);
            getEnemyManager().addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (getTimeBossEnemy() >= 850) { // 850 frames = 14.2 seconds
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
