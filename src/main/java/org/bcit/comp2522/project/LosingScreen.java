package org.bcit.comp2522.project;

import processing.core.PFont;

/**
 * The LosingScreen class is responsible for displaying the losing screen of the game.
 * It displays the player's score and prompts the user to enter their name for high score recording.
 * It also logs the high score into the database.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class LosingScreen {
  private final Window parent;
  private final int size = 400;

  /**
   * Constructor for the LosingScreen class.
   *
   * @param parent the Window object to use for the game UI.
   */
  public LosingScreen(Window parent) {
    this.parent = parent;
  }

  /**
   * Displays the losing screen with the player's score and a prompt to enter their name.
   */
  public void display() {
    PFont gameFont;
    String dataPath = parent.sketchPath("fonts");
    gameFont = parent.createFont("" + dataPath + "/Righteous-Regular.ttf", size);
    parent.textFont(gameFont);
    parent.background(0);
    parent.textSize(50);
    parent.textAlign(parent.CENTER, parent.CENTER);
    parent.text("OH NO\nYOU LOST  :( "
            + "\nYour score was :" + Player.getCurrentScore(),
            Window.windowWidth / 2, Window.windowHeight / 3);

    parent.text("ENTER YOUR NAME:", Window.windowWidth / 3, Window.windowHeight * 8 / 12);
    parent.fill(111, 185, 15);
    parent.text(parent.getUserInput().toUpperCase(),
            Window.windowWidth * 2 / 3, Window.windowHeight * 8 / 12);

    parent.fill(255);
    parent.text("HIT ENTER TO SAVE", Window.windowWidth * 2 / 3, Window.windowHeight * 10 / 12);
  }

  /**
   * Logs the high score into the database and sets the stage to 1(start screen).
   */
  public void logHighscore() {
    DatabaseHandler dbh = new DatabaseHandler();
    dbh.insertHighScore(parent.getUserInput().toUpperCase(), Player.getCurrentScore());
    parent.setUserInput("");
    parent.setStage(1);

  }


}
