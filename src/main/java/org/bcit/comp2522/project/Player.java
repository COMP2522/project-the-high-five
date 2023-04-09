package org.bcit.comp2522.project;

/**
 * Represents the player in the game, including their current level score, coins, and health.
 * This class follows the Singleton design pattern to ensure that there is only one instance of the player.
 * Also provides methods for accessing and modifying the player's attributes.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Player {
    private static Player player;
    private static int currentScore;
    private static int coins;
   private static int health;

    /**
     * Constructor for the Player class. Intializes the player's attributes to their default values.
     */
    private Player() {
        currentScore = 0;
        coins = 100;
        health = 10;
    }

    /**
     * Returns the current score of the player.
     * @return the current score of the player.
     */
    public static int getCurrentScore() {
        return currentScore;
    }

    /**
     * Sets the current score of the player.
     * @param currentScore an integer representing the player's new current score.
     */
    public static void setCurrentScore(int currentScore) {
        Player.currentScore = currentScore;
    }

    /**
     * Returns the current amount of coins the player has.
     * @return the current amount of coins the player has.
     */
    public static int getCoins() {
        return coins;
    }

    /**
     * Sets the curret amount of coins the player has.
     * @param coins an integer representing the player's new current coins.
     */
    public static void setCoins(int coins) {
        Player.coins = coins;
    }

    /**
     * Return the current health of the player.
     * @return the current health of the player.
     */
    public static int getHealth() {
        return health;
    }

    /**
     * Sets the current health of the player.
     * @param health an integer representing the player's new current health.
     */
    public static void setHealth(int health) {
        Player.health = health;
    }

    /**
     * Returns the instance of the Player class. If no instance exists, creates one.
     * @return the Player instance.
     */
    public static Player getInstance() {
        if (player == null) {
            player = new Player();

        }
        return player;
    }

    /**
     * Resets the player's coins to the default value.
     */
    public static void resetStats() {
        Player.setCoins(100);
    }
}
