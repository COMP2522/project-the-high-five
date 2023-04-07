package org.bcit.comp2522.project;

import processing.core.PImage;

public class UI {

  public PImage coinImage;
  public PImage hpImage;
  Window window;

  public UI(Window window) {
    this.window = window;
  }

  public void setup() {
    coinImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/coin3.png");
    hpImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/redHeart.png");
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
    window.text(hp, 1050, 659);
    window.image(hpImage, 1067, 631, 32, 32);
  }

  public void displayCoins() {
    int coins = Player.getCoins();
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text(coins, 615, 563);
    window.image(coinImage, 645, 537, 32, 32);
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
