package org.bcit.comp2522.project;

public class Level_2 extends Level {
  Window window;
  public Level_2(Window window){
    super(window);
    this.window = window;
    init();
  }

  public void init(){
    getPath().clearCorner();
    getPath().addCorner(40,288);
    getPath().addCorner(184,288);
    getPath().addCorner(184,384);
    getPath().addCorner(472,384);
    getPath().addCorner(472,288);
    getPath().addCorner(712,288);
    getPath().addCorner(1192,288);
    getPath().connectCorners();
  }

  public void draw(){
    window.background(0);
    getPath().draw();
    System.out.println(getPath().getHead());
    window.grid.draw();


  }
}
