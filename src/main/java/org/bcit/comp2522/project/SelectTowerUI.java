package org.bcit.comp2522.project;

import processing.core.PImage;

public class SelectTowerUI {
  private Window window;
  private PImage inventoryIMG;

  private PImage tower1;

  private TileMap tileMap;

  private int selectedTower;
  public SelectTowerUI(Window window, TileMap tileMap){
    this.window = window;
    this.tileMap = tileMap;
    inventoryIMG = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/towerslot.png");
    tower1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/tower1icon.png").get(0,0,96,96);
    selectedTower = 0;
  }

  public void selectTower(){
    //System.out.println("Mouse Pos:" + window.mouseX + ", " + window.mouseY);
    if(window.mousePressed && (window.mouseX > 408 && window.mouseX < 472 && window.mouseY > 608 && window.mouseY < 672)){
      System.out.println("Tower 1 selected");
      selectedTower = 1;
    }
  }

  public void slotClicked(){
    if (selectedTower != 0 && tileMap.setTower(selectedTower)){
      System.out.println("Tower placed");
      selectedTower = 0;
    }
  }

  public void draw(){
    window.image(inventoryIMG, 376, 576);
    //window.square(440, 640, 64);
    window.image(tower1, 395, 595,96,96);
  }
}
