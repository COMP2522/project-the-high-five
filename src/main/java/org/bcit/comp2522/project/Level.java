package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

/**
 The Level class represents a level of the game. It contains a path, tile map, enemy manager, tower manager,
 bullet manager, select tower UI, and a number of enemies. It also includes methods to reset the level, set the number of
 enemies, get the path, window, tile map, enemy manager, bullet manager, select tower UI, and towers. It also includes
 methods to set and get the time for regular, fast, and boss enemies, as well as methods to increase the time for these
 types of enemies. The Level class is responsible for initializing, drawing, and resetting the level.
 */

public class Level {
  private Path path;
  private final Window window;
  private TileMap tileMap;
  private EnemyManager enemyManager;
  private BulletManager bulletManager;
  private SelectTowerUI selectTowerUI;
  public ArrayList<Tower> getTowers() {
    return towers;
  }

  private ArrayList<Tower> towers;

  public TowerManager getTowerManager() {
    return towerManager;
  }

  private TowerManager towerManager;
  private PImage tilemapImg;
  protected int numEnemies = 10;
  private int timeRegularEnemy;
  private int timeFastEnemy;
  private int timeBossEnemy;

  /**
   Constructs a new Level object with a given window and initializes the level.
   @param window the window object for the level.
   */
  public Level(Window window){
    //path = new Path(window);
    this.window = window;
    levelreset();

  }

  /**
  Resets the level by creating a new path, loading the tile map image, creating new enemy, tower, and bullet managers,
  creating a new tile map, resetting the time for regular, fast, and boss enemies, and creating a new select tower UI.
  */
  public void levelreset(){
    path = new Path(window);
    tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
    enemyManager = new EnemyManager(window);
    towerManager = new TowerManager(window);
    bulletManager = new BulletManager(window);
    tileMap = new TileMap(window, getPath(), towerManager, bulletManager);
    timeRegularEnemy = 0;
    timeFastEnemy = 0;
    timeBossEnemy = 0;
    selectTowerUI = new SelectTowerUI(getWindow(), getTileMap(), towerManager);
  }

  /**
   Sets the number of enemies for the level.
   @param numEnemies the number of enemies for the level.
   */
  public void setNumEnemies(int numEnemies){
    this.numEnemies = numEnemies;
  }

  /**
   Returns the path for the level.
   @return the path for the level.
   */
  public Path getPath() {
    return path;
  }

  /**
   Returns the window for the level.
   @return the window for the level.
   */
  public Window getWindow() {
    return window;
  }

  /**

   Returns the tile map for the level.
   @return the tile map for the level.
   */
  public TileMap getTileMap() {
    return tileMap;
  }

  /**
  Returns the enemy manager for the level.
  @return the enemy manager for the level.
  */
  public void reset(){
    path.reset();
  }

  /**
   Initializes the level.
   */
  public void init(){
  }

  /**
   Draws the level.
   */
  public void draw(){
  }

  /**
   Returns the time for boss enemies.
   @return the time for boss enemies.
   */
  public int getTimeBossEnemy() {
    return timeBossEnemy;
  }

  /**
   Sets the time for the boss enemy to appear.
   @param timeBossEnemy the time for the boss enemy to appear.
   */
  public void setTimeBossEnemy(int timeBossEnemy) {
    this.timeBossEnemy = timeBossEnemy;
  }

  /**
   Returns the current time for regular enemies.
   @return the current time for regular enemies.
   */
  public int getTimeRegularEnemy() {
    return timeRegularEnemy;
  }

  /**
   Sets the time for regular enemies to appear.
   @param timeRegularEnemy the time for regular enemies to appear.
   */
  public void setTimeRegularEnemy(int timeRegularEnemy) {
    this.timeRegularEnemy = timeRegularEnemy;
  }

  /**
   Returns the current time for fast enemies.
   @return the current time for fast enemies.
   */
  public int getTimeFastEnemy() {
    return timeFastEnemy;
  }

  /**
   Sets the time for fast enemies to appear.
   @param timeFastEnemy the time for fast enemies to appear.
   */
  public void setTimeFastEnemy(int timeFastEnemy) {
    this.timeFastEnemy = timeFastEnemy;
  }

  /**
   Increases the current time for regular enemies by a given amount.
   @param timeRegularEnemy the amount of time to increase the current time for regular enemies.
   */
  public void increaseTimeRegularEnemy(int timeRegularEnemy) {
    this.timeRegularEnemy += timeRegularEnemy;
  }

  /**
   Increases the current time for fast enemies by a given amount.
   @param timeFastEnemy the amount of time to increase the current time for fast enemies.
   */
  public void increaseTimeFastEnemy(int timeFastEnemy) {
    this.timeFastEnemy += timeFastEnemy;
  }

  /**
   Increases the current time for boss enemies by a given amount.
   @param timeBossEnemy the amount of time to increase the current time for boss enemies.
   */
  public void increaseTimeBossEnemy(int timeBossEnemy) {
    this.timeBossEnemy += timeBossEnemy;
  }

  /**
   Returns the EnemyManager for this Level.
   @return the EnemyManager for this Level.
   */
  public EnemyManager getEnemyManager() {
    return enemyManager;
  }

  /**
  Returns the BulletManager for this Level.
  @return the BulletManager for this Level.
  */
  public BulletManager getBulletManager() {
    return bulletManager;
  }

  /**
  Returns the tile map image for the level.
  @return the tile map image for the level.
  */
  public PImage getTilemapImg() {
    return tilemapImg;
  }

  /**
   Returns the SelectTowerUI for this Level.
   @return the SelectTowerUI for this Level.
   */
  public SelectTowerUI getSelectTowerUI() {
    return selectTowerUI;
  }
}
