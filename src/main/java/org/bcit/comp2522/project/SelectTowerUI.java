package org.bcit.comp2522.project;

import processing.core.PImage;

/**
 * SelectTowerUI.java
 * Represents the UI for selecting and placing a tower.
 *
 * @author Aric Or
 * @version 1.0
 */
public class SelectTowerUI {

  /* The window that the UI is drawn on. */
  private Window window;
  /* The image of the inventory slot. */
  private PImage inventoryIMG;
  /* The image of the tower. */
  private PImage tower1;
  /* The tile map that the tower is placed on. */
  private TileMap tileMap;
  /* The tower manager that manages the towers. */
  TowerManager towerManager;
  /* Whether the tower is selected. */
  private int selectedTower;

  /**
   * Constructs a SelectTowerUI object.
   *
   * @param window       the window that the UI is drawn on
   * @param tileMap      the tile map that the tower is placed on
   * @param towerManager the tower manager that manages the towers
   */
  public SelectTowerUI(Window window, TileMap tileMap, TowerManager towerManager) {
    this.window = window;
    this.tileMap = tileMap;
    inventoryIMG = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/towerslot.png");
    tower1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/tower1icon.png")
            .get(0, 0, 96, 96);
    selectedTower = 0;
    this.towerManager = towerManager;
  }

  /**
   * Selects the tower when the player clicks on the tower slot.
   */
  public void selectTower() {
    //checking if the mouse was pressed at the position of tower slot
    if ((Player.getCoins() / 50) > 0 && window.mousePressed && (window.mouseX > 408
            && window.mouseX < 472 && window.mouseY > 608 && window.mouseY < 672)) {
      selectedTower = 1;
    }
  }

  /**
   * Handles the logic for placing a tower on the tile map when a slot is clicked.
   * If a tower is selected and can be placed,
   * the tower is added to the tile map and the player's coins are decreased.
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
    window.image(tower1, 391, 596, 96, 96);
  }
}
