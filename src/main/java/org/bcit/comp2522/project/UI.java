package org.bcit.comp2522.project;

import processing.core.PImage;

/**
 * UI.java
 * Manages the user interface elements of the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class UI {
  /* The width and height of the hearts in the UI. */
  private static final int ELEMENT_SIZE = 32;
  PImage coinImage;
  PImage redHeart;
  PImage blackHeart;
  private Window window;

  /**
   * Constructor for UI class.
   *
   * @param window The Window object for accessing the LevelManager and updating the game display.
   */
  public UI(Window window) {
    this.window = window;
  }

  /**
   * Loads up the UI elements.
   */
  public void setup() {
    coinImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/coin3.png");
    redHeart = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/redHeart.png");
    blackHeart = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/blackHeart.png");
  }

  /**
   * Displays the current level number.
   *
   * @return The text that was displayed.
   */
  public String displayLevelNumber() {
    String text = "Level " + (LevelManager.getCurrentLevel() + 1);
    displayText(text, 190, 85);
    return text;
  }

  /**
   * Displays the current score.
   *
   * @return The text that was displayed.
   */
  public String displayScore() {
    String text = "Score: " + Player.getCurrentScore();
    displayText(text, 600, 85);
    return text;
  }

  /**
   * Displays the number of enemies defeated.
   *
   * @return The text that was displayed.
   */
  public String displayEnemiesDefeated() {
    String text = "Enemies Defeated: " + EnemyManager.getEnemiesKilled();
    displayText(text, 1050, 85);
    return text;
  }

  /**
   * Displays the player's current health using a combination of red and black hearts.
   *
   * @return The text that was displayed.
   */
  public String displayHP() {
    int hp = Player.getHealth();
    if (hp == 10) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 967, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 665, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 9) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 967, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 8) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 967, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 7) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 967, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 6) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 967, 665, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 5) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1100, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 967, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 4) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1066, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 967, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 3) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1033, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 967, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 2) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(redHeart, 1000, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 967, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 1) {
      window.image(redHeart, 967, 631, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 967, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    } else if (hp == 0) {
      window.image(blackHeart, 967, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 633, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 967, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1000, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1033, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1066, 667, ELEMENT_SIZE, ELEMENT_SIZE);
      window.image(blackHeart, 1100, 667, ELEMENT_SIZE, ELEMENT_SIZE);
    }
    displayText(String.valueOf(hp), 950, 659);
    return String.valueOf(hp);
  }

  /**
   * Displays the player's current coins.
   *
   * @return The player's current coins.
   */
  public String displayCoins() {
    String text = String.valueOf(Player.getCoins());
    displayText(text, 180, 659);
    window.image(coinImage, 210, 632, ELEMENT_SIZE, ELEMENT_SIZE);
    return text;
  }

  /**
   * Displays the text on the screen.
   *
   * @param text The text to display.
   * @param x    The x coordinate of the text.
   * @param y    The y coordinate of the text.
   */
  private void displayText(String text, int x, int y) {
    window.textAlign(window.CENTER);
    window.textSize(ELEMENT_SIZE);
    window.fill(255, 255, 255);
    window.text(text, x, y);
  }
}
