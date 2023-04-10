package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * This class represents the tilemap on which the game is played.
 */
public class TileMap {
  private int[][] map;

  private Path path;

  private TowerManager towerManager;

  private BulletManager bulletManager;
  private final int ROW;
  private final int COL;

  private Window window;

  /**
   * Constructor of this class.
   * @param window represents the window this class is displayed on.
   * @param path represents the path the enemies travel on.
   * @param towerManager represents array of towers.
   * @param bulletManager represents array of bullets.
   */
  public TileMap(Window window, Path path, TowerManager towerManager, BulletManager bulletManager){
    this.window = window;
    this.path = path;
    this.towerManager = towerManager;
    this.bulletManager = bulletManager;
    ROW = 15;
    COL = 25;
    map = new int[15][25];
    for (int i = 0; i < 15; i++){
      for (int j = 0; j < 25; j++){
        map[i][j] = 0;
      }
    }

  }

  /**
   * Getter method to return the map
   * @return
   */
  public int[][] getMap() {
    return map;
  }

  /**
   * This method sets the path on the tilemap.
   * Lets the tilemap know what exact position the path's nodes are on.
   */
  public void setPath(){
    Node current = path.getHead();
    while (current != null){
      int x = current.getXpos() - 40;
      int y = current.getYpos();
      int row = y/48;
      int col = x/48;
      map[row][col] = 1;
      current = current.next;
    }


  }

  /**
   * Print out the tilemap. Used for debugging.
   */
  public void checkMap(){

     // System.out.println("Tile check:");
      for (int i = 0; i < 15; i++){
        for (int j = 0; j < 25; j++){
          System.out.print(map[i][j] + " ");
        }
        System.out.println();

    }
  }

  /**
   * This method checks if the selected Tower can be placed on the tilemap.
   * If player is trying to place tower on path, method will return false.
   * @param selectedTower represents a specific tower.
   * @return true or false.
   */
  public boolean setTower(int selectedTower){

    if (selectedTower != 0) {
      if (window.mousePressed && (window.mouseX > 40 && window.mouseX < 1240) && (window.mouseY > 0 && window.mouseY < 576)) {

        int x = window.mouseX - 40;
        int y = window.mouseY;
        int row = y / 48;
        int col = x / 48;
        // if this location on the grid is valid then place tower
        if (map[row][col] != 1) {
          map[row][col] = selectedTower;
          towerManager.add(new Tower(col*48+40, row*48, window, bulletManager));
          //System.out.println("Tower placement" + col*48 + ", " + row*48);
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }


}
