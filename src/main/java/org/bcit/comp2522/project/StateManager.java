
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

    public void pull() {
        GameState gs = dbh.getGameState(window);
        LevelManager lm = window.getLevelManager();
        Player.setHealth(gs.getPlayerHealth());
        Player.setCoins(gs.getCoins());
        Player.setCurrentScore(gs.getCurrentScore());
        lm.setTimeBossEnemy(gs.getTimeBossEnemy());
        lm.setTimeFastEnemy(gs.getTimeFastEnemy());
        lm.setTimeRegularEnemy(gs.getTimeFastEnemy());
        LevelManager.setCurrentLevel(gs.getCurrentLevel());


    }
}
