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



    //private final ArrayList<Enemy> enemies;
    private int health;
    private int coins;



    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    private int score;



    private int currentLevel;
    private int timeRegularEnemy;
    private int timeFastEnemy;
    private int timeBossEnemy;

    private int enemiesKilled;


    public GameState(Player player, Window window, LevelManager lm) {

        this.player = player;
        this.health = Player.getHealth();
        this.coins = Player.getCoins();
        this.score = Player.getCoins();
        this.currentLevel = LevelManager.getCurrentLevel();
        this.timeBossEnemy = lm.getTimeBossEnemy();
        this.timeFastEnemy = lm.getTimeFastEnemy();
        this.timeRegularEnemy = lm.getTimeRegularEnemy();
        this.enemiesKilled = EnemyManager.getEnemiesKilled();

    }

    public void updateCoins() {
        this.coins = Player.getCoins();
    }



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
    public int getTimeRegularEnemy() {
        return timeRegularEnemy;
    }

    public int getTimeFastEnemy() {
        return timeFastEnemy;
    }

    public int getTimeBossEnemy() {
        return timeBossEnemy;
    }

    public void setTimeRegularEnemy(int timeRegularEnemy) {
        this.timeRegularEnemy = timeRegularEnemy;
    }

    public void setTimeFastEnemy(int timeFastEnemy) {
        this.timeFastEnemy = timeFastEnemy;
    }

    public void setTimeBossEnemy(int timeBossEnemy) {
        this.timeBossEnemy = timeBossEnemy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getEnemiesKilled(){
        return enemiesKilled;
    }




}