package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeAll;
import processing.core.PApplet;
import processing.core.PImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Class that tests the functionality of Tower class.
 * @author gursidhsanhdhu
 */
public class TowerTest {

  static Window window;
  static Tower tower;
  static BulletManager bulletManager;
  PImage towerImg;

  @BeforeEach
   void setup(){
    window = new Window();
    bulletManager = new BulletManager(window);
    tower = new Tower(205,400,window,bulletManager);
    towerImg = window.loadImage("Tower 06.png");

  }

  @Test
  public void checkXPos(){
    assertEquals(205, tower.getXpos(),0.01);
  }

  @Test
  public void checkNegativeXPos(){
    tower = new Tower(-205,400,window,bulletManager);
    assertEquals(-205,tower.getXpos(),0.01);
  }

  @Test
  public void checkYPos(){

    assertEquals(400, tower.getYpos(),0.01);
}

@Test
public void checkNegativeYPos(){
    tower = new Tower(200,-400,window,bulletManager);
    assertEquals(-400,tower.getYpos(),0.01);
}

  @Test
  public void testProperTowerConstruction() {
    tower = new Tower(205,400,window,bulletManager);
    assertEquals(205, tower.getXpos(), 0.01);
    assertEquals(400, tower.getYpos(), 0.01);
    assertEquals(window, tower.window);
    assertNotNull(tower);
  }


}
