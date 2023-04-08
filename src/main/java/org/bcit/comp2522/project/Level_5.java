package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_5 extends Level{

    public Level_5(Window window) {
        super(window);
        init();
    }

    public void init() {
        levelreset();

        getPath().clearCorner();
        getPath().addCorner(40, 480);
        getPath().addCorner(184, 480);
        getPath().addCorner(184, 192);
        getPath().addCorner(568, 192);
        getPath().addCorner(568, 480);
        getPath().addCorner(376, 480);
        getPath().addCorner(376, 48);
        getPath().addCorner(808, 48);
        getPath().addCorner(808, 576);
        getPath().addCorner(1096, 576);
        getPath().addCorner(1096, 240);
        getPath().addCorner(952, 240);
        getPath().addCorner(952, 384);
        getPath().addCorner(1232, 384);

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
            getTowerManager().draw();
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
        if (getTimeFastEnemy() >= 400) { // 400 frames = 6.7 seconds
            setTimeFastEnemy(0);
            getEnemyManager().addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (getTimeBossEnemy() >= 750) { // 750 frames = 12.5 seconds
            setTimeBossEnemy(0);
            getEnemyManager().addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 4, 1, 1, 3, this));
        }

        // towerMethods
        getTowerManager().shoot(getEnemyManager());
        getTowerManager().inRange();

        getBulletManager().update();
        getEnemyManager().update(getBulletManager());
        //getWindow().grid.draw();
        //tileMap.checkMap();

    }
}
