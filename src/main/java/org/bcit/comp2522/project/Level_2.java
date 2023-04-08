package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_2 extends Level {

    //SelectTowerUI selectTowerUI;


    public Level_2(Window window) {
        super(window);

        init();
    }

    public void init() {
//        tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
//        enemyManager = new EnemyManager(window);
//        towers = new ArrayList<>();
//        bulletManager = new BulletManager(window);
//        tileMap = new TileMap(window, getPath(), towers, bulletManager);
        levelreset();
        //levelManager = new LevelManager(window, 5);
//        setTimeRegularEnemy(0);
//        setTimeFastEnemy(0);
//        setTimeBossEnemy(0);
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
        getPath().addCorner(376, 288);
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
        }

        // Update the timer
        increaseTimeRegularEnemy(1);
        increaseTimeFastEnemy(1);
        increaseTimeBossEnemy(1);

        // Check if it's time to spawn a new regular enemy
        if (getTimeRegularEnemy() >= 400) { // 400 frames = 6.6 seconds
            setTimeRegularEnemy(0);
            getEnemyManager().addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 2, 2, 2, 2, this));
        }

        // Check if it's time to spawn a new fast enemy
        if (getTimeFastEnemy() >= 500) { // 500 frames = 8 seconds
            setTimeFastEnemy(0);
            getEnemyManager().addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (getTimeBossEnemy() >= 1200) { // 1200 frames = 20 seconds
            setTimeBossEnemy(0);
            getEnemyManager().addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 4, 1, 1, 3, this));
        }

        for (Tower tower : getTowers()) {
            tower.draw();
            //tower.inRange(enemyManager);
            tower.shootingEnemy(getEnemyManager());
            if (tower.isInRange()) {
                getWindow().stroke(255, 0, 0);
            } else {
                getWindow().stroke(0, 0, 0);
            }
        }
        getBulletManager().update();
        getEnemyManager().update(getBulletManager());
        getWindow().grid.draw();
        //tileMap.checkMap();
    }
}
