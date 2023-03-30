package org.bcit.comp2522.project;

public class TileMap {
  private int[][] map;

  private Path path;
  private final int ROW;
  private final int COL;

  private Window window;
  public TileMap(Window window, Path path){
    this.window = window;
    this.path = path;
    ROW = 15;
    COL = 25;
    map = new int[15][25];
    for (int i = 0; i < 15; i++){
      for (int j = 0; j < 25; j++){
        map[i][j] = 0;
      }
    }

  }

  public int[][] getMap() {
    return map;
  }

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
    System.out.println("Tile check:");
//    for (int i = 0; i < 15; i++){
//      for (int j = 0; j < 25; j++){
//        System.out.print(map[i][j] + " ");
//      }
//      System.out.println();
//    }

  }
  public void checkMap(){
    if (window.mousePressed && (window.mouseX > 40 && window.mouseX < 1240) && (window.mouseY > 0 && window.mouseY < 720)){
      int x = window.mouseX - 40;
      int y = window.mouseY;
      int row = y/48;
      int col = x/48;
      map[row][col] = 1;
      System.out.println("Tile check:");
      for (int i = 0; i < 15; i++){
        for (int j = 0; j < 25; j++){
          System.out.print(map[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
