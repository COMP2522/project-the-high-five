
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

    public void mainPull() {
        GameState gs = dbh.getGameState(window);
        LevelManager lm = window.getLevelManager();
        lm.setTimeBossEnemy(gs.getTimeBossEnemy());
        lm.setTimeFastEnemy(gs.getTimeFastEnemy());
        lm.setTimeRegularEnemy(gs.getTimeFastEnemy());


    }

    public void pull(){
        GameState gs = dbh.getGameState(window);
        Player.setCurrentScore(gs.getCurrentScore());
        Player.setCoins(gs.getCoins());
        Player.setHealth(gs.getPlayerHealth());
        LevelManager.setCurrentLevel(gs.getCurrentLevel());
        EnemyManager.setEnemiesKilled(gs.getEnemiesKilled());
    }
}
