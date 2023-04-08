package org.bcit.comp2522.project;

public class Level {
  private Path path;
  private Window window;
  private StateManager sm;
  private TileMap tileMap;
  protected int numEnemies = 10;
  public Level(Window window){
    this.window = window;
    path = new Path(window);
    sm = new StateManager(window, new GameState(Player.getInstance(), window));
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
    if (window.getStage() == 2) {
      sm.push(new GameState(Player.getInstance(), window));

    }

  }
}
