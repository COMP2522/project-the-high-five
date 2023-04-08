package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_2 extends Level {
    Window window;
    EnemyManager enemyManager;
    PImage tilemapImg;
    SelectTowerUI selectTowerUI;
    private ArrayList<Tower> towers;
    private BulletManager bulletManager;
    private TileMap tileMap;

    public Level_2(Window window) {
        super(window);
        this.window = window;
        init();
    }

    public void init() {
        tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
        enemyManager = new EnemyManager(window);
        towers = new ArrayList<>();
        bulletManager = new BulletManager(window);
        tileMap = new TileMap(window, getPath(), towers, bulletManager);
        levelManager = new LevelManager(window, 5);
        levelManager.setTimeRegularEnemy(0);
        levelManager.setTimeFastEnemy(0);
        levelManager.setTimeBossEnemy(0);
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
        tileMap.setPath();
        selectTowerUI = new SelectTowerUI(window, tileMap);
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
        }

        // Update the timer
        levelManager.setTimeRegularEnemy(levelManager.getTimeRegularEnemy() + 1);
        levelManager.setTimeFastEnemy(levelManager.getTimeFastEnemy() + 1);
        levelManager.setTimeBossEnemy(levelManager.getTimeBossEnemy() + 1);

        // Check if it's time to spawn a new regular enemy
        if (levelManager.getTimeRegularEnemy() >= 400) { // 400 frames = 6.6 seconds
            levelManager.setTimeRegularEnemy(0);
            enemyManager.addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 2, this));
        }

        // Check if it's time to spawn a new fast enemy
        if (levelManager.getTimeFastEnemy() >= 500) { // 500 frames = 8 seconds
            levelManager.setTimeFastEnemy(0);
            enemyManager.addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (levelManager.getTimeBossEnemy() >= 1200) { // 1200 frames = 20 seconds
            levelManager.setTimeBossEnemy(0);
            enemyManager.addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 3, this));
        }

        for (Tower tower : towers) {
            tower.draw();
            //tower.inRange(enemyManager);
            tower.shootingEnemy(enemyManager);
            if (tower.isInRange()) {
                window.stroke(255, 0, 0);
            } else {
                window.stroke(0, 0, 0);
            }
        }
        bulletManager.update();
        enemyManager.update(bulletManager);
        window.grid.draw();
        //tileMap.checkMap();
    }
}
