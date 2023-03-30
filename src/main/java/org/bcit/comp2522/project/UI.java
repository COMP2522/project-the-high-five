package org.bcit.comp2522.project;

import processing.core.PApplet;

public class UI extends PApplet {

  Window window;

  public UI(Window window) {
    this.window = window;
  }

  public void displayLevelNumber(int levelNumber) {
    textAlign(CENTER);
    textSize(32);
    fill(255, 255, 255);
    text("Level " + levelNumber, 640, 360);
  }

  public void displayEnemiesDefeated(int enemiesDefeated) {
    textAlign(CENTER);
    textSize(32);
    fill(255, 255, 255);
    text("Enemies Defeated: " + enemiesDefeated, 640, 360);
  }

  public void displayHP(int hp) {
    textAlign(CENTER);
    textSize(32);
    fill(255, 255, 255);
    text("HP: " + hp, 640, 360);
  }

  public void displayPlayPauseButton(boolean isPlaying) {
    textAlign(CENTER);
    textSize(32);
    fill(255, 255, 255);
    if (isPlaying) {
      text("Pause", 640, 360);
    } else {
      text("Play", 640, 360);
    }
  }

}
