package org.bcit.comp2522.project;

public class Level {
  private Path path;
  private Window window;
  //LevelManager levelManager;
  private TileMap tileMap;
  protected int numEnemies = 10;

  private int timeRegularEnemy;
  private int timeFastEnemy;
  private int timeBossEnemy;

  public Level(Window window){
    path = new Path(window);
    timeRegularEnemy = 0;
    timeFastEnemy = 0;
    timeBossEnemy = 0;
  }

  public void setNumEnemies(int numEnemies){
    this.numEnemies = numEnemies;
  }

  public Path getPath() {
    return path;
  }

  public Window window() {
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
}
