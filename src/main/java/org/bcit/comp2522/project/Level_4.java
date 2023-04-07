package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_4 extends Level {
    Window window;
    EnemyManager enemyManager;
    PImage tilemapImg;
    SelectTowerUI selectTowerUI;
    private ArrayList<Tower> towers;
    private BulletManager bulletManager;
    private TileMap tileMap;
    private int timeRegularEnemy;
    private int timeFastEnemy;
    private int timeBossEnemy;

    public Level_4(Window window) {
        super(window);
        this.window = window;
        init();
    }

    public void init() {
        tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
        timeBossEnemy = 0;
        timeFastEnemy = 0;
        timeRegularEnemy = 0;
        enemyManager = new EnemyManager(window);
        towers = new ArrayList<>();
        bulletManager = new BulletManager(window);
        tileMap = new TileMap(window, getPath(), towers, bulletManager);
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
        timeRegularEnemy++;
        timeFastEnemy++;
        timeBossEnemy++;

        // Check if it's time to spawn a new regular enemy
        if (timeRegularEnemy >= 300) { // 300 frames = 5 seconds
            timeRegularEnemy = 0;
            enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 2, this));
        }

        // Check if it's time to spawn a new fast enemy
        if (timeFastEnemy >= 450) { // 450 frames = 7.5 seconds
            timeFastEnemy = 0;
            enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (timeBossEnemy >= 850) { // 850 frames = 14.2 seconds
            timeBossEnemy = 0;
            enemyManager.addEnemy(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 3, this));
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
