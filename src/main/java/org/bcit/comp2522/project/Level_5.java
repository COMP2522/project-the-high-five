package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_5 extends Level{
    Window window;
    EnemyManager enemyManager;
    PImage tilemapImg;
    SelectTowerUI selectTowerUI;
    TowerManager towerManager;
    private BulletManager bulletManager;
    private TileMap tileMap;

    public Level_5(Window window) {
        super(window);
        this.window = window;
        init();
    }

    public void init() {
        tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
        enemyManager = new EnemyManager(window);
        towerManager = new TowerManager(window);
        bulletManager = new BulletManager(window);
        tileMap = new TileMap(window, getPath(), towerManager, bulletManager);
        levelManager = new LevelManager(window, 5);
        levelManager.setTimeRegularEnemy(0);
        levelManager.setTimeFastEnemy(0);
        levelManager.setTimeBossEnemy(0);
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
        tileMap.setPath();
        selectTowerUI = new SelectTowerUI(window, tileMap, towerManager);
    }

    public void draw() {
        if (Player.getHealth() <= 0) {
            window.setStage(3);

        } else {
            if (super.numEnemies <= 0) {
                window.setStage(4);
            }
            window.background(0);
            window.image(tilemapImg, 40, 0);
            getPath().draw();
            selectTowerUI.draw();
            selectTowerUI.selectTower();
            selectTowerUI.slotClicked();
            towerManager.draw();
        }

        // Update the timer
        levelManager.setTimeRegularEnemy(levelManager.getTimeRegularEnemy() + 1);
        levelManager.setTimeFastEnemy(levelManager.getTimeFastEnemy() + 1);
        levelManager.setTimeBossEnemy(levelManager.getTimeBossEnemy() + 1);

        // Check if it's time to spawn a new regular enemy
        if (levelManager.getTimeRegularEnemy() >= 300) { // 300 frames = 5 seconds
            levelManager.setTimeRegularEnemy(0);
            enemyManager.addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 2, this));
        }

        // Check if it's time to spawn a new fast enemy
        if (levelManager.getTimeFastEnemy() >= 400) { // 400 frames = 6.7 seconds
            levelManager.setTimeFastEnemy(0);
            enemyManager.addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (levelManager.getTimeBossEnemy() >= 750) { // 750 frames = 12.5 seconds
            levelManager.setTimeBossEnemy(0);
            enemyManager.addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 3, this));
        }

        // towerMethods
        towerManager.shoot(enemyManager);
        towerManager.inRange();

        bulletManager.update();
        enemyManager.update(bulletManager);
        window.grid.draw();
        //tileMap.checkMap();

    }
}
