package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the functionality of TowerManager class.
 * @author gursidhsandhu
 */
public class TowerManagerTest {

  private String[] appletArgs = new String[]{"towerDefence"};
  static TowerManager towerManager;
  static Window window;
  static Tower tower;
  static EnemyManager enemyManager;
  static BulletManager bulletManager;

  @BeforeEach
    void setup(){
    window = new Window();
    PApplet.runSketch(appletArgs, window);
    towerManager = new TowerManager(window);
    tower = new Tower(0, 0, window, bulletManager);
    enemyManager = new EnemyManager(window);
  }

  @Test
  public void addTower(){
    towerManager.add(tower);
    assertNotNull(tower);
  }


}
