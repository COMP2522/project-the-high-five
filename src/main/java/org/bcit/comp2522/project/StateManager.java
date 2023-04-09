
package org.bcit.comp2522.project;

/**
 * Manages the game state by reading and writing it to the database. It has reference to the current GameState and
 * DatabaseHanlder objects, as well as a Window object.
 */
public class StateManager {

    private final GameState gamestate;
    private final DatabaseHandler dbh;

    private final Window window;

    /**
     * Constructor for StateManager class. Initializes the GameState, DatabaseHandler and Window objects.
     * @param window The Window object for accessing the LevelManager and updating the game display.
     * @param lm The LevelManager object for manging the game levels.
     */
    StateManager(Window window, LevelManager lm) {
        this.window = window;
        gamestate = new GameState(Player.getInstance(), window, lm);
        dbh = new DatabaseHandler();

    }


    /**
     * Writes the given GameState to the database.
     * @param gameState the GameState object to be written to the database.
     */
    public void push(GameState gameState) {
        dbh.writeGameState(gameState);
    }

    /**
     * Reads the main game state from the database and updates the LevelManager with the data.
     */
    public void mainPull() {
        GameState gs = dbh.getGameState(window);
        LevelManager lm = window.getLevelManager();
        lm.setTimeBossEnemy(gs.getTimeBossEnemy());
        lm.setTimeFastEnemy(gs.getTimeFastEnemy());
        lm.setTimeRegularEnemy(gs.getTimeFastEnemy());


    }

    /**
     * Reads the player's game state from the database and updates the Player and LevelManager objects with the data.
     */
    public void pull(){
        GameState gs = dbh.getGameState(window);
        Player.setCurrentScore(gs.getCurrentScore());
        Player.setCoins(gs.getCoins());
        Player.setHealth(gs.getPlayerHealth());
        LevelManager.setCurrentLevel(gs.getCurrentLevel());
        EnemyManager.setEnemiesKilled(gs.getEnemiesKilled());
    }
}
