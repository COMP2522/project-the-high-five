package org.bcit.comp2522.project;

/**
 The LevelManager class is responsible for managing the levels of the game.
 It keeps track of the current level, the number of levels, and an array of Level objects.
 It also manages the timing of different enemy types, and updates the UI to display important information.
 */
public class LevelManager {
  private static int currentLevel;
  private Level[] levels;
  private Level currentLevelObject;
  private final int numberOfLevels;
  private UI ui;
  private Window window;

  private StateManager sm;

  private int timeRegularEnemy;
  private int timeFastEnemy;
  private int timeBossEnemy;

  /**
   * Constructs a new LevelManager object.
   *
   * @param window         the Window object to use for the game UI.
   * @param numberOfLevels the total number of levels in the game.
   */
  public LevelManager(Window window, int numberOfLevels) {
    currentLevel = 0;
    this.numberOfLevels = numberOfLevels;
    levels = new Level[numberOfLevels];
    currentLevelObject = levels[0];
    ui = new UI(window);

    timeRegularEnemy = 0;
    timeBossEnemy = 0;
    timeFastEnemy = 0;
    sm = new StateManager(window, this);
    ui.setup();
    this.window = window;

  }

  /**
   * Gets the amount on the timer for regular enemy.
   *
   * @return integer for the timer of a regular enemy.
  public int getTimeRegularEnemy() {
    return timeRegularEnemy;
  }

  /**
   * Sets the amount on the timer for the regular enemy.
   *
   * @param timeRegularEnemy the timer for the regular enemy.
   */
  public void setTimeRegularEnemy(int timeRegularEnemy) {
    this.timeRegularEnemy = timeRegularEnemy;
  }

  /**
   * Gets the amount of timer for the fast enemy.
   *
   * @return the time for the fast enemy.
   */
  public int getTimeFastEnemy() {
    return timeFastEnemy;
  }

  /**
   * Sets the amount of timer for the fast enemy.
   *
   * @param timeFastEnemy integer for the amount on the timer for the fast enemy.
   */
  public void setTimeFastEnemy(int timeFastEnemy) {
    this.timeFastEnemy = timeFastEnemy;
  }

  /**
   * Returns the amount on the timer for a boss enemy.
   *
   * @return the amount on the timer for a boss enemy.
   */
  public int getTimeBossEnemy() {
    return timeBossEnemy;
  }

  /**
   * Sets the amount on the timer for a boss enemy.
   *
   * @param timeBossEnemy the amount on the timer for a boss enemy.
   */
  public void setTimeBossEnemy(int timeBossEnemy) {
    this.timeBossEnemy = timeBossEnemy;
  }
  public static void setCurrentLevel(int currentLevel){
    LevelManager.currentLevel = currentLevel;
  }

  public Level getCurrentLevelObject() {
    return currentLevelObject;
  }

  /**
   * Draws the current level.
   */
  public void draw() {
    //System.out.println("drawing level:" + currentLevel);
    levels[currentLevel].draw();
    //ui.setup();
    ui.displayEnemiesDefeated();
    ui.displayLevelNumber();
    ui.displayScore();
    ui.displayHP();
    ui.displayCoins();

  }


  /**
   * Advances the game to the next level.
   * If the current level is the final level, the game will loop back to the beginning.
   */
  public void nextLevel() {
    if (currentLevel == numberOfLevels - 1) {
      currentLevel = 0;
    } else {
      currentLevel++;
      Player.resetStats();
    }
    levels[currentLevel].init();
  }

  /**
   * Adds a new level to the game.
   *
   * @param level the Level object to add.
   */
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

  /**
   * Returns the current level.
   *
   * @return the current level.
   */
  public static int getCurrentLevel() {
    return currentLevel;
  }


  public int getTimeRegularEnemy() {
    return timeRegularEnemy;
  }
}
