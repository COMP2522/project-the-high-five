package org.bcit.comp2522.project;

public class Level_1 {
  private Path path;
  private Window window;
  public Level_1(Window window){
    this.window = window;
    path = new Path(window);
    path.addCorner(40, 432);
    path.addCorner(328, 432);
    path.connectCorners();
  }

  public void draw(){
    path.draw();
  }
}
