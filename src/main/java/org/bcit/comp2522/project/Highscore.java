package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Represents a player's highscore in the game.
 * Stores the highscore value and the user's name as a string.
 */
public class Highscore {


  private int highscore;
  private String user;


  /**
   * Creates and empty Highscore object.
   */
  public Highscore() {

  }

  /**
   * Creates a Highscore object with a specified user name and highscore value.
   *
   * @param user the name of the user.
   */
  public Highscore(String user) {

    this.highscore = Player.getCurrentScore();
    this.user = user;
  }

  /**
   * Returns the highscore value.
   *
   * @return the highscore value.
   */
  public int getHighscore() {
    return highscore;
  }

  /**
   * Sets the highscore value.
   *
   * @param highscore the new highscore value.
   */
  public void setHighscore(int highscore) {
    this.highscore = highscore;
  }

  /**
   * Returns the name of the user.
   *
   * @return the name of the user.
   */
  public String getUser() {
    return user;
  }

  /**
   * Sets the name of the user.
   *
   * @param user the new name of the user.
   */
  public void setUser(String user) {
    this.user = user;
  }


  /**
   * Publishes the current highscore to the database.
   */
  public void publishHighscore() {
    DatabaseHandler dbh = new DatabaseHandler();
    dbh.insertHighScore(user, highscore);
  }

  /**
   * Retrieves the list of highscore from the database and return it as an ArrayList.
   *
   * @return the list of highscores as an ArrayList of Highscore objects.
   */
  public ArrayList<Highscore> retrieveHighscores() {
    DatabaseHandler dbh = new DatabaseHandler();
    return dbh.retrieveHighScores();
  }

}





