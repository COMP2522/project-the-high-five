package org.bcit.comp2522.project;

import processing.core.PImage;

/**
 * This class represents when a tower object is selected by the player.
 */
public class SelectTowerUI {
  private Window window;
  private PImage inventoryIMG;

  private PImage tower1;

  private TileMap tileMap;
  TowerManager towerManager;

  private int selectedTower;

  /**
   * Constructor of this class.
   * @param window represents the window it is displayed on.
   * @param tileMap represents the map.
   * @param towerManager represents the towerManager class that handles all tower objects.
   */
  public SelectTowerUI(Window window, TileMap tileMap, TowerManager towerManager){
    this.window = window;
    this.tileMap = tileMap;
    inventoryIMG = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/towerslot.png");
    tower1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/tower1icon.png").get(0,0,96,96);
    selectedTower = 0;
    this.towerManager = towerManager;
  }

  /**
   * This class checks if a player has selected a tower from the tower slot position.
   */
  public void selectTower(){
    //checking if the mouse was pressed at the position of tower slot
    if(window.mousePressed && (window.mouseX > 408 && window.mouseX < 472 && window.mouseY > 608 && window.mouseY < 672)){
      selectedTower = 1;
    }
  }

  /**
   * This method represents when a tower is placed in a slot on the tilemap.
   * If this happens, then a tower cannot be moved anymore.
   */
  public void slotClicked(){
    if (selectedTower != 0 && tileMap.setTower(selectedTower)){
      selectedTower = 0;
    }
  }

  /**
   * This method simply draws the tower slot from where a tower can be selected.
   */
  public void draw(){
    window.image(inventoryIMG, 376, 576);
    //window.square(440, 640, 64);
    window.image(tower1, 395, 595,96,96);
  }
}
