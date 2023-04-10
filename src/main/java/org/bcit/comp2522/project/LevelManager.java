package org.bcit.comp2522.project;

/**
 The LevelManager class is responsible for managing the levels of the game.
 It keeps track of the current level, the number of levels, and an array of Level objects.
 It also manages the timing of different enemy types,
 and updates the UI to display important information.
 */
public class LevelManager {
  private static int currentLevel;
  private Level[] levels;
  private Level currentLevelObject;
  private final int numberOfLevels;
  private UI ui;
  private Window window;
  private StateManager sm;


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
    sm = new StateManager(window, this);
    ui.setup();
    this.window = window;

  }

  /**
   * Sets the current level for the game.
   *
   * @param currentLevel integer to set the current level.
   */
  public static void setCurrentLevel(int currentLevel) {
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
      Player.setCoins(100);
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

}
