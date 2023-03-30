package org.bcit.comp2522.project;

public class UI {

  Window window;

  public UI(Window window) {
    this.window = window;
  }

  public void displayLevelNumber(int levelNumber) {
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("Level " + levelNumber, 640, 85);
  }

  public void displayEnemiesDefeated(int enemiesDefeated) {
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("Enemies Defeated: " + enemiesDefeated, 1050, 85);
  }

  public void displayHP(int hp) {
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    window.text("HP: " + hp, 1050, 635);
  }

  public void displayPlayPauseButton(boolean isPlaying) {
    window.textAlign(window.CENTER);
    window.textSize(32);
    window.fill(255, 255, 255);
    if (isPlaying) {
      window.text("Pause", 640, 635);
    } else {
      window.text("Play", 640, 635);
    }
  }

}
