package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level {
  private Path path;
  private final Window window;
  //LevelManager levelManager;
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

  public Level(Window window){
    //path = new Path(window);
    this.window = window;
    levelreset();

  }

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

  public void setNumEnemies(int numEnemies){
    this.numEnemies = numEnemies;
  }


  public Path getPath() {
    return path;
  }

  public Window getWindow() {
    return window;
  }

  public TileMap getTileMap() {
    return tileMap;
  }

  public void reset(){
    path.reset();
  }

  public void init(){
  }

  public void draw(){
  }

  public int getTimeBossEnemy() {
    return timeBossEnemy;
  }

  public void setTimeBossEnemy(int timeBossEnemy) {
    this.timeBossEnemy = timeBossEnemy;
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

  public void increaseTimeRegularEnemy(int timeRegularEnemy) {
    this.timeRegularEnemy += timeRegularEnemy;
  }

  public void increaseTimeFastEnemy(int timeFastEnemy) {
    this.timeFastEnemy += timeFastEnemy;
  }

  public void increaseTimeBossEnemy(int timeBossEnemy) {
    this.timeBossEnemy += timeBossEnemy;
  }

  public EnemyManager getEnemyManager() {
    return enemyManager;
  }

  public BulletManager getBulletManager() {
    return bulletManager;
  }

  public PImage getTilemapImg() {
    return tilemapImg;
  }

  public SelectTowerUI getSelectTowerUI() {
    return selectTowerUI;
  }
}
