
package org.bcit.comp2522.project;

public class StateManager {

    private final GameState gamestate;
    private final DatabaseHandler dbh;

    private final Window window;

    StateManager(Window window, LevelManager lm) {
        this.window = window;
        gamestate = new GameState(Player.getInstance(), window, lm);
        dbh = new DatabaseHandler();

    }


    public void push(GameState gameState) {
        dbh.writeGameState(gameState);
    }
}

