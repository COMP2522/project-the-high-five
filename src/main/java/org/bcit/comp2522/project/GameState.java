package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Creates GameState information to save.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class GameState {

    private final Player player;
    //private TowerManager towerManager;
    private final EnemyManager enemyManager;

    //private final ArrayList<Enemy> enemies;
    private final int health;
    private final int coins;


    private final int score;
    private int time;
    private final int currentLevel;
    private int timeRegularEnemy;
    private int timeFastEnemy;
    private int timeBossEnemy;


    public GameState(Player player, Window window, LevelManager lm) {

            this.player = player;
            this.enemyManager = window.enemyManager;
            this.health = Player.getHealth();
            this.coins = Player.getCoins();
            this.score = Player.getCoins();
            this.currentLevel = LevelManager.getCurrentLevel();

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

    public int getCurrentLevel() {
        return currentLevel;
    }




}
