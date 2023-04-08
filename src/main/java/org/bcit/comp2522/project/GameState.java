package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Creates GameState information to save.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class GameState {

    private Player player;
    //private TowerManager towerManager;
    private EnemyManager enemyManager;

    //private final ArrayList<Enemy> enemies;
    private int health;
    private int coins;


    private int score;
    private int time;
    private Level currentLevel;
    private int timeRegularEnemy;
    private int timeFastEnemy;
    private int timeBossEnemy;


    public GameState(Player player, Window window) {

            this.player = player;
            this.enemyManager = window.enemyManager;
            this.health = Player.getHealth();
            this.coins = Player.getCoins();
            this.score = Player.getCoins();
            this.currentLevel = window.levelManager.getCurrentLevelObject();
            //this.enemies = window.enemyManager.getEnemies();

    }

//    public ArrayList<Enemy> getEnemies() {
//        return enemies;
//    }

    public int getPlayerHealth() {
        return health;
    }

    public int getCoins() {
        return coins;
    }

    public int getCurrentScore() {
        return score;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }




}
