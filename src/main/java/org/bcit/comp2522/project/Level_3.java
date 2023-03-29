package org.bcit.comp2522.project;

public class Level_3 extends Level {
  public Level_3(Window window) {
    super(window);
    getPath().addCorner(40, 432);
    getPath().addCorner(328, 432);
    getPath().connectCorners();
  }
}
