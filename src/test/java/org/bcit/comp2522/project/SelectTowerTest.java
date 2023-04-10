package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import processing.core.PImage;
import processing.core.PApplet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SelectTowerTest {

  private static String[] appletArgs = new String[]{"towerDefence"};
  private static Window window;
  private static PImage inventoryImage;
  private static PImage towerImage;
  private static TileMap tileMap;
  private static Path path;
  private static TowerManager towerManager;
  private static BulletManager bulletManager;
  private static int selected;

  @BeforeAll
  static void setup() {
    window = new Window();
    PApplet.runSketch(appletArgs, window);
    inventoryImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/towerslot.png");
    towerImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/tower1icon.png")
            .get(0, 0, 96, 96);
    tileMap = new TileMap(window, path, towerManager, bulletManager);
    towerManager = new TowerManager(window);
    selected = 0;
  }

  @Test
  void selectTowerUIObjectIsCreated() {
    SelectTowerUI selectTowerUI = new SelectTowerUI(window, tileMap, towerManager);
    assertNotEquals(null, selectTowerUI);
  }

  @Test
  void selectTowerSelectionTest() {
    SelectTowerUI selectTowerUI = new SelectTowerUI(window, tileMap, towerManager);
    int initialCoins = Player.getCoins();
    Player.setCoins(50);
    window.mousePressed = true;
    window.mouseX = 410;
    window.mouseY = 610;
    selectTowerUI.selectTower();
    assertEquals(0, selected);
    Player.setCoins(initialCoins);
  }

  @Test
  void slotClickedTest() {
    SelectTowerUI selectTowerUI = new SelectTowerUI(window, tileMap, towerManager);
    int initialCoins = Player.getCoins();
    Player.setCoins(50);
    selected = 1;
    selectTowerUI.slotClicked();
    assertEquals(1, selected);
    assertEquals(initialCoins - 50, Player.getCoins());
  }
}
