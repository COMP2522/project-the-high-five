package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Stores and manages the current state of the game, including player's information level information and tower
 * information.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class GameState {

    private final Player player;

    private int health;
    private int coins;

   private ArrayList<Tower> towers;

    private int score;

    private int currentLevel;
    private int timeRegularEnemy;
    private int timeFastEnemy;
    private int timeBossEnemy;

    private int enemiesKilled;


    /**
     * Constructor for the GameState class. Intializes the player's information and level information.
     * @param player the current player
     * @param window the game window
     */
    public GameState(Player player, Window window) {

        this.player = player;
        this.health = Player.getHealth();
        this.coins = Player.getCoins();
        this.score = Player.getCurrentScore();
        this.currentLevel = LevelManager.getCurrentLevel();
        this.enemiesKilled = EnemyManager.getEnemiesKilled();
        //this.towers = lm.getCurrentLevelObject().getTowers();

    }

    /**
     * Sets the current level to the given level.
     *
     * @param currentLevel the level to set as the current level
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Return's the player's health.
     *
     * @return the player's health.
     */
    public int getPlayerHealth() {
        return health;
    }

    /**
     * Returns the current amount of coins the players has.
     *
     * @return an integer representing the amount of coins the player has.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Returns the current score.
     *
     * @return an integer representing the current score of the player.
     */
    public int getCurrentScore() {
        return score;
    }

    /**
     * Returns the current level of the game.
     *
     * @return an integer representing the current level of the game.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Returns the time between each regular enemy spawn.
     *
     * @return an integer representing the time between each regular enemy spawn.
     */
    public int getTimeRegularEnemy() {
        return timeRegularEnemy;
    }

    /**
     * Returns the time between each fast enemy spawn.
     *
     * @return an integer representing the time between each fast enemy spawn.
     */
    public int getTimeFastEnemy() {
        return timeFastEnemy;
    }

    /**
     * Returns the time between each boss enemy spawn.
     *
     * @return an integer representing the time between each boss enemy spawn.
     */
    public int getTimeBossEnemy() {
        return timeBossEnemy;
    }

    /**
     * Sets the time between each regular enemy spawn to the given time.
     *
     * @param timeRegularEnemy the time between each regular enemy spawn
     */
    public void setTimeRegularEnemy(int timeRegularEnemy) {
        this.timeRegularEnemy = timeRegularEnemy;
    }

    /**
     * Sets the time between each fast enemy spawn to the given time.
     *
     * @param timeFastEnemy the time between each fast enemy spawn
     */
    public void setTimeFastEnemy(int timeFastEnemy) {
        this.timeFastEnemy = timeFastEnemy;
    }

    /**
     * Sets the time between each boss enemy spawn to the given time.
     *
     * @param timeBossEnemy the time between each boss enemy spawn
     */public void setTimeBossEnemy(int timeBossEnemy) {
        this.timeBossEnemy = timeBossEnemy;
    }

    /**
     * Sets the player's health to the given value.
     * @param health integer value to set the player's health to.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the number of coins the player current has.
     *
     * @param coins the number of coins to set.
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Sets the current score of the player.
     *
     * @param score the score to set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Returns the number of enemies the player has killed.
     *
     * @return the number of enemies killed.
     */
    public int getEnemiesKilled(){
        return enemiesKilled;
    }

    /**
     * Sets the number of enemies the player has killed.
     *
     * @param killed the number of enemies killed to set.
     */
    public void setEnemiesKilled(int killed){
        this.enemiesKilled = killed;
    }

    /**
     * Sets the ArrayList of tower the player current owns.
     *
     * @return an ArrayList of towers.
     */
    public ArrayList<Tower> getTowers(){
        return towers;
    }

    /**
     * Sets the ArrayList of towers the player currentl owns.
     *
     * @param towers the ArrayList of towers to set
     */
    public void setTowers(ArrayList<Tower> towers){
        this.towers = towers;
    }




}