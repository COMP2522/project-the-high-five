package org.bcit.comp2522.project;

import processing.core.PImage;

public class UI {

  public PImage coinImage;
  public PImage redHeart;
  public PImage pinkHeart;
  Window window;

  public UI(Window window) {
    this.window = window;
  }

  public void setup() {
    coinImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/coin3.png");
    redHeart = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/redHeart.png");
    pinkHeart = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/pinkHeart.png");
  }

  public void displayLevelNumber() {
    int levelNumber = LevelManager.getCurrentLevel() + 1;
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("Level " + levelNumber, 190, 85);
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
    if (hp == 10) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
      window.image(redHeart, 1033, 631, 32, 32);
      window.image(redHeart, 1066, 631, 32, 32);
      window.image(redHeart, 1100, 631, 32, 32);
    } else if (hp == 9) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
      window.image(redHeart, 1033, 631, 32, 32);
      window.image(redHeart, 1066, 631, 32, 32);
      window.image(pinkHeart, 1100, 633, 32, 32);
    } else if (hp == 8) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
      window.image(redHeart, 1033, 631, 32, 32);
      window.image(redHeart, 1066, 631, 32, 32);
    } else if (hp == 7) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
      window.image(redHeart, 1033, 631, 32, 32);
      window.image(pinkHeart, 1066, 633, 32, 32);
    } else if (hp == 6) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
      window.image(redHeart, 1033, 631, 32, 32);
    } else if (hp == 5) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
      window.image(pinkHeart, 1033, 633, 32, 32);
    } else if (hp == 4) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(redHeart, 1000, 631, 32, 32);
    } else if (hp == 3) {
      window.image(redHeart, 967, 631, 32, 32);
      window.image(pinkHeart, 1000, 631, 32, 32);
    } else if (hp == 2) {
      window.image(redHeart, 967, 631, 32, 32);
    } else if (hp == 1) {
      window.image(pinkHeart, 967, 633, 32, 32);
    }
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text(hp, 950, 659);
  }

  public void displayCoins() {
    int coins = Player.getCoins();
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text(coins, 180, 659);
    window.image(coinImage, 210, 632, 32, 32);
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
