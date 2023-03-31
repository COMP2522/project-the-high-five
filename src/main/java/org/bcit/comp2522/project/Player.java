package org.bcit.comp2522.project;

public class Player {
    private static Player player;
    private int currentLevel;
    private int currentScore;
    private int coins;
   private int health;

    private Player() {
        currentLevel = 0;
        currentScore = 1000;
        coins = 100;
        health = 10;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }





    public static Player getInstance() {
        if (player == null) {
            player = new Player();

        }
        return player;

    }

    public static void resetStats() {
        player.setCoins(0);
        player.setCoins(10);

    }


}
