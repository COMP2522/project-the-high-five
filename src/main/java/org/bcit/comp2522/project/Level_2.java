package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Level_2 extends Level {
  Window window;
  private TileMap tileMap;
  private ArrayList<Tower> towers;

  PImage tilemapImg;
  public Level_2(Window window){
    super(window);
    this.window = window;

    tilemapImg = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/map.png");
    init();
  }

  public void init(){
    towers = new ArrayList<>();
    tileMap = new TileMap(window, getPath(), towers);
    getPath().clearCorner();
    getPath().addCorner(40,384);
    getPath().addCorner(280,384);
    getPath().addCorner(280,528);
    getPath().addCorner(520,528);
    getPath().addCorner(520,96);
    getPath().addCorner(856,96);
    getPath().addCorner(856,288);
    getPath().addCorner(664,288);
    getPath().addCorner(664,432);
    getPath().addCorner(1192,432);
    //getPath().addCorner(376,288);
    getPath().connectCorners();

    tileMap.setPath();
  }

  public void draw(){
    window.background(0);
    window.image(tilemapImg, 40, 0);
    getPath().draw();
    //System.out.println(getPath().getHead());
    //window.grid.draw();


  }
}
