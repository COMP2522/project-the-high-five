package org.bcit.comp2522.project;

public class UI {

  Window window;

  public UI(Window window) {
    this.window = window;
  }

  public void displayLevelNumber() {
    int levelNumber = LevelManager.getCurrentLevel() + 1;
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("Level " + levelNumber, 640, 85);
  }

  public void displayEnemiesDefeated() {
    int enemiesDefeated = EnemyManager.getEnemiesKilled();
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("Enemies Defeated: " + enemiesDefeated, 1050, 85);
  }

  public void displayHP() {
    int hp = Player.getHealth();
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("HP: " + hp, 1050, 658);
  }

  public void displayCoins() {
    int coins = Player.getCoins();
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("Coins: " + coins, 640, 570);
  }

  public void displayPlayPauseButton(boolean isPlaying) {
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    if (isPlaying) {
      window.text("Pause", 640, 658);
    } else {
      window.text("Play", 640, 658);
    }
  }

}
