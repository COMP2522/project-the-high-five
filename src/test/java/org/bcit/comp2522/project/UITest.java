package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UITest {
  private String[] appletArgs = new String[]{"towerDefence"};
  private Window window;
  private PImage coinImage;
  private PImage redHeart;
  private PImage blackHeart;
  private UI ui;

  @BeforeEach
  void setup() {
    window = new Window();
    PApplet.runSketch(appletArgs, window);
    coinImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/coin3.png");
    redHeart = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/redHeart.png");
    blackHeart = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/blackHeart.png");
    ui = new UI(window);
    ui.setup();
  }

  @Test
  void testConstructor() {
    assertNotNull(ui);
  }

  @Test
  void testSetup() {
    assertNotNull(ui.coinImage);
    assertNotNull(ui.redHeart);
    assertNotNull(ui.blackHeart);
  }

  @Test
  void testDisplayLevelNumber1() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(0); // Set the current level to 3 (0-indexed)
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 1", levelText);
  }

  @Test
  void testDisplayLevelNumber2() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(1); // Set the current level to 3 (0-indexed)
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 2", levelText);
  }

  @Test
  void testDisplayLevelNumber3() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(2); // Set the current level to 3 (0-indexed)
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 3", levelText);
  }

  @Test
  void testDisplayLevelNumber4() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(3); // Set the current level to 3 (0-indexed)
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 4", levelText);
  }

  @Test
  void testDisplayLevelNumber5() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(4); // Set the current level to 3 (0-indexed)
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 5", levelText);
  }

  @Test
  void testDisplayScore() {
    UI ui = new UI(window);
    Player.setCurrentScore(500); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 500", scoreText);
  }

  @Test
  void testDisplayEnemiesDefeated() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(10); // Set the number of enemies killed to 10
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 10", enemiesDefeatedText);
  }

  @Test
  void testDisplayHP() {
    UI ui = new UI(window);
    Player.setHealth(75); // Set the player's health to 75
    String hpText = ui.displayHP();
    assertEquals("75", hpText);
  }

//  @Test
//  void testDisplayCoins() {
//    UI ui = new UI(window);
//    Player.setCoins(15); // Set the player's coins to 15
//    String coinsText = ui.displayCoins();
//    assertEquals("15", coinsText);
//  }
}
