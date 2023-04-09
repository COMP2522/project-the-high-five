package org.bcit.comp2522.project;

public class LevelManager {
  private static int currentLevel;
  private final Level[] levels;
  private final Level currentLevelObject;
  private final int numberOfLevels;
  UI ui;
  private int timeRegularEnemy;
  private int timeFastEnemy;
  private int timeBossEnemy;

  private Window window;

  private final StateManager sm;

  public LevelManager(Window window, int numberOfLevels) {
    currentLevel = 0;
    this.numberOfLevels = numberOfLevels;
    levels = new Level[numberOfLevels];
    currentLevelObject = levels[0];
    sm = new StateManager(window, this);
    ui = new UI(window);
    timeRegularEnemy = 0;
    timeFastEnemy = 0;
    timeBossEnemy = 0;
    ui.setup();
  }

  public Level getCurrentLevelObject() {
    return levels[currentLevel];
  }

  public int getTimeRegularEnemy() {
    return timeRegularEnemy;
  }

  public void setTimeRegularEnemy(int timeRegularEnemy) {
    this.timeRegularEnemy = timeRegularEnemy;
  }

  public int getTimeFastEnemy() {
    return timeFastEnemy;
  }

  public void setTimeFastEnemy(int timeFastEnemy) {
    this.timeFastEnemy = timeFastEnemy;
  }

  public int getTimeBossEnemy() {
    return timeBossEnemy;
  }

  public void setTimeBossEnemy(int timeBossEnemy) {
    this.timeBossEnemy = timeBossEnemy;
  }


  public void draw() {
    //System.out.println("drawing level:" + currentLevel);
    levels[currentLevel].draw();
    //ui.setup();
    ui.displayEnemiesDefeated();
    ui.displayLevelNumber();
    ui.displayHP();
    ui.displayCoins();
    if (window.getStage() == 2) {
      sm.push(new GameState(Player.getInstance(), window, this));

    }
  }

  public void nextLevel() {
    if (currentLevel == numberOfLevels - 1) {
      currentLevel = 0;

      //currentLevelObject = levels[currentLevel];
    } else {
      currentLevel++;
      Player.resetStats();

      //currentLevelObject = levels[currentLevel];
    }
    levels[currentLevel].init();
  }

  public void addLevel(Level level) {
    int n = 0;
    while (levels[n] != null) {
      if (n == numberOfLevels - 1) {
        return;
      }
      n++;
    }
    levels[n] = level;
  }

  public static int getCurrentLevel() {
    return currentLevel;
  }

  /**
   * This is just a temporary method to kill off enemies to trigger losing
   * function faster for testing purposes.  DELETE LATER
   */
  public void killEnemies() {
    levels[currentLevel].setNumEnemies(0);
  }

  public void killPlayer() {
    Player.setHealth(0);
  }


}
