package org.bcit.comp2522.project;

/**
 Level_4 class is a subclass of Level that represents the fourth level of the game.
 It initializes the level's components, draws the game objects on the screen,
 and checks when it is time to spawn a new enemy or to end the level.
 @author quintessentialquintuplets
 @version 1.0
 */
public class Level_4 extends Level {

    /**
     * Constructs a Level_4 object.
     * @param window the window that the level is drawn on
     */
    public Level_4(Window window) {
        super(window);
        init();
    }

    /**
     Initializes the level by resetting the level, adding corners to the path, and setting the path on the tile map.
     It also updates the timer and checks if it's time to spawn a new enemy.
     */
    public void init() {
        levelreset();

        getPath().clearCorner();
        getPath().addCorner(40, 336);
        getPath().addCorner(520, 336);
        getPath().addCorner(520, 96);
        getPath().addCorner(808, 96);
        getPath().addCorner(808, 240);
        getPath().addCorner(952, 240);
        getPath().addCorner(952, 48);
        getPath().addCorner(1144, 48);
        getPath().addCorner(1144, 432);
        getPath().addCorner(1144, 528);
        getPath().addCorner(1144, 624);
        getPath().addCorner(808, 624);
        getPath().addCorner(808, 432);
        getPath().addCorner(1232, 432);

        getPath().connectCorners();
        getTileMap().setPath();
    }

    /**
     Draws the game objects on the screen, updates the timer and checks if it's time to spawn a new enemy.
     It also checks if the game is over, and if all enemies are defeated.
     */
    public void draw() {
        if (Player.getHealth() <= 0) {
            getWindow().setStage(3);

        } else {
            if (super.numEnemies <= 0) {
                getWindow().setStage(4);
            }
            getWindow().background(0);
            getWindow().image(getTilemapImg(), 40, 0);
            getPath().draw();
            getSelectTowerUI().draw();
            getSelectTowerUI().selectTower();
            getSelectTowerUI().slotClicked();
            getTowerManager().draw();
        }

        // Update the timer
        increaseTimeRegularEnemy(1);
        increaseTimeFastEnemy(1);
        increaseTimeBossEnemy(1);

        // Check if it's time to spawn a new regular enemy
        if (getTimeRegularEnemy() >= 300) { // 300 frames = 5 seconds
            setTimeRegularEnemy(0);
            getEnemyManager().addEnemy(new Beetle(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 2, 2, 2, 2, this));
        }

        // Check if it's time to spawn a new fast enemy
        if (getTimeFastEnemy() >= 450) { // 450 frames = 7.5 seconds
            setTimeFastEnemy(0);
            getEnemyManager().addEnemy(new Locust(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 1, 4, 4, 1, this));
        }

        // Check if it's time to spawn a new boss enemy
        if (getTimeBossEnemy() >= 850) { // 850 frames = 14.2 seconds
            setTimeBossEnemy(0);
            getEnemyManager().addEnemy(new Bee(getPath().getHead().getXpos(), getPath().getHead().getYpos(), getWindow(), 4, 1, 1, 3, this));
        }

        // towerMethods
        getTowerManager().shoot(getEnemyManager());
        getTowerManager().inRange();

        getBulletManager().update();
        getEnemyManager().update(getBulletManager());
    }
}
