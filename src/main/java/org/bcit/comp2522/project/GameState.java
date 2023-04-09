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
    private final int health;
    private final int coins;

    private final int score;

    private final int currentLevel;
    private int timeRegularEnemy;
    private int timeFastEnemy;
    private int timeBossEnemy;


    public GameState(Player player, Window window, LevelManager lm) {

        this.player = player;
        this.health = Player.getHealth();
        this.coins = Player.getCoins();
        this.score = Player.getCoins();
        this.currentLevel = LevelManager.getCurrentLevel();
        this.timeBossEnemy = lm.getTimeBossEnemy();
        this.timeFastEnemy = lm.getTimeFastEnemy();
        this.timeRegularEnemy = lm.getTimeRegularEnemy();

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




}