package org.bcit.comp2522.project;

public class Player {
    private static Player player;
    int currentLevel;
    int currentScore;
    int coins;

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

  int health;


    private Player() {
        currentLevel = 0;
        currentScore = 0;
        coins = 0;
    }


    public static Player getInstance() {
        if (player == null) {
            player = new Player();

        }
        return player;

    }


}
