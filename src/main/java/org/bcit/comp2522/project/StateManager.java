
package org.bcit.comp2522.project;

import org.json.JSONObject;

/**
 * Manages the game state by reading and writing it to the database.
 * It has reference to the current GameState and
 * DatabaseHanlder objects, as well as a Window object.
 */
public class StateManager {

  private final GameState gamestate;
  private final DatabaseHandler dbh;

  private final Window window;

  private GameState gs;


  /**
   * Constructor for StateManager class. Initializes the
   * GameState, DatabaseHandler and Window objects.
   *
   * @param window The Window object for accessing the LevelManager and updating the game display.
   * @param lm     The LevelManager object for manging the game levels.
   */
  StateManager(Window window, LevelManager lm) {
    this.window = window;
    gamestate = new GameState(Player.getInstance(), window);
    dbh = new DatabaseHandler();


  }


  /**
   * Writes the given GameState to the database.
   *
   * @param jsonObject the GameState object to be written to the database.
   */
  public void push(JSONObject jsonObject) {
    dbh.writeGameState(jsonObject);
  }

  /**
   * Reads the main game state from the database and updates the LevelManager with the data.
   */
  public void mainPull(LevelManager lm) {
    gs = dbh.getGameState(window);
    //LevelManager.setCurrentLevel(gs.getCurrentLevel());
    //EnemyManager.setEnemiesKilled(gs.getEnemiesKilled());
    //Player.setCoins(gs.getCoins());


  }

  /**
   * Reads the player's game state from the database
   * and updates the Player and LevelManager objects with the data.
   */
  public void pull() {
    GameState gs = dbh.getGameState(window);
    Player.setCurrentScore(gs.getCurrentScore());
    Player.setCoins(gs.getCoins());
    Player.setHealth(gs.getPlayerHealth());
    LevelManager.setCurrentLevel(gs.getCurrentLevel());
    EnemyManager.setEnemiesKilled(gs.getEnemiesKilled());
  }


}
