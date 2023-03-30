package org.bcit.comp2522.project;

public class Level {
  private Path path;
  private Window window;

  private TileMap tileMap;
  public Level(Window window){
    path = new Path(window);
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
}
