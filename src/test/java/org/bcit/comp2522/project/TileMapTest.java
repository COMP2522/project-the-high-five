package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the functionality of the TileMap Class.
 * @author gursidhsandhu.
 */
public class TileMapTest {

  private String[] appletArgs = new String[]{"towerDefence"};
  private TileMap tileMap;
  private Window window;
  private Path path;
  private TowerManager towerManager;
  private BulletManager bulletManager;


  @BeforeEach
  void setup(){
    window = new Window();
    PApplet.runSketch(appletArgs, window);
    path = new Path(window);
    towerManager = new TowerManager(window);
    bulletManager = new BulletManager(window);
    tileMap = new TileMap(window,path,towerManager,bulletManager);
  }

  @Test
  void testMapObject(){
    int[][] tm = tileMap.getMap();
    assertNotNull(tm);
  }

  @Test
  void testSetTower(){
    int[][] tm = tileMap.getMap();
    tm[1][3] = 2;
    // should not be able to place on path
    assertFalse(tileMap.setTower(2));
  }

  @Test
  void testSetPath(){
    // set path first to test
    tileMap.setPath();
    // assign object to path
    // use object in testing instead of having to use getter everytime.
    int[][] tm = tileMap.getMap();
    // should be 0 because nothing in path
    assertEquals(0,tm[2][2]);

  }

}

