package org.bcit.comp2522.project;

import processing.core.PImage;

public class SelectTowerUI {
  private Window window;
  private PImage inventoryIMG;

  private PImage tower1;

  private TileMap tileMap;
  TowerManager towerManager;

  private int selectedTower;
  /**
   * Constructs a SelectTowerUI object.
   * @param window the window that the UI is drawn on
   * @param tileMap the tile map that the tower is placed on
   * @param towerManager the tower manager that manages the towers
   */
  public SelectTowerUI(Window window, TileMap tileMap, TowerManager towerManager) {
    this.window = window;
    this.tileMap = tileMap;
    inventoryIMG = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/towerslot.png");
    tower1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/tower1icon.png").get(0, 0, 96, 96);
    selectedTower = 0;
    this.towerManager = towerManager;
  }
  /**
   * Select the tower.
   */
  public void selectTower() {
    //checking if the mouse was pressed at the position of tower slot
    if ((Player.getCoins() / 50) > 0 && window.mousePressed && (window.mouseX > 408 && window.mouseX < 472 && window.mouseY > 608 && window.mouseY < 672)) {
      selectedTower = 1;
    }
  }

  /**
   * Slot clicked. Adds the tower to the tile map.
   */
  public void slotClicked() {
    if (selectedTower != 0 && tileMap.setTower(selectedTower)) {
      selectedTower = 0;
      Player.setCoins(Player.getCoins() - 50);
    }
  }
  /**
   * Draws the Tower Selection UI.
   */
  public void draw() {
    window.image(inventoryIMG, 376, 576);
    //window.square(440, 640, 64);
    window.image(tower1, 391, 596, 96, 96);
  }
}
