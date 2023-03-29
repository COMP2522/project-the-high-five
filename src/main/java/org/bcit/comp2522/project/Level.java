package org.bcit.comp2522.project;

public class Level {
  private Path path;
  private Window window;
  public Level(Window window){
    path = new Path(window);
  }
  public Path getPath() {
    return path;
  }

  public Window window() {
    return window;
  }

  public void reset(){
    path.reset();
  }
  public void init(){
  }
  public void draw(){
  }
}
