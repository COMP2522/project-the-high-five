package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UITest {
  private static String[] appletArgs = new String[]{"towerDefence"};
  private static Window window;
  private static PImage coinImage;
  private static PImage redHeart;
  private static PImage blackHeart;
  private static UI ui;

  @BeforeAll
  static void setup() {
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
  void testDisplayScore1() {
    UI ui = new UI(window);
    Player.setCurrentScore(500); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 500", scoreText);
  }

  @Test
  void testDisplayScore2() {
    UI ui = new UI(window);
    Player.setCurrentScore(2000); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 2000", scoreText);
  }

  @Test
  void testDisplayScore3() {
    UI ui = new UI(window);
    Player.setCurrentScore(769); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 769", scoreText);
  }

  @Test
  void testDisplayScore4() {
    UI ui = new UI(window);
    Player.setCurrentScore(17); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 17", scoreText);
  }

  @Test
  void testDisplayScore5() {
    UI ui = new UI(window);
    Player.setCurrentScore(3); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 3", scoreText);
  }

  @Test
  void testDisplayScore6() {
    UI ui = new UI(window);
    Player.setCurrentScore(0); // Set the current score to 500
    String scoreText = ui.displayScore();
    assertEquals("Score: 0", scoreText);
  }

  @Test
  void testDisplayEnemiesDefeated1() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(10); // Set the number of enemies killed to 10
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 10", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated2() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(0); // Set the number of enemies killed to 10
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 0", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated3() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(3); // Set the number of enemies killed to 10
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 3", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated4() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(4); // Set the number of enemies killed to 10
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 4", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated5() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(20); // Set the number of enemies killed to 10
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 20", enemiesDefeatedText);
  }

  @Test
  void testDisplayHP1() {
    UI ui = new UI(window);
    Player.setHealth(75); // Set the player's health to 75
    String hpText = ui.displayHP();
    assertEquals("75", hpText);
  }

  @Test
  void testDisplayHP2() {
    UI ui = new UI(window);
    Player.setHealth(1); // Set the player's health to 75
    String hpText = ui.displayHP();
    assertEquals("1", hpText);
  }

  @Test
  void testDisplayHP3() {
    UI ui = new UI(window);
    Player.setHealth(9); // Set the player's health to 75
    String hpText = ui.displayHP();
    assertEquals("9", hpText);
  }

  @Test
  void testDisplayHP4() {
    UI ui = new UI(window);
    Player.setHealth(7); // Set the player's health to 75
    String hpText = ui.displayHP();
    assertEquals("7", hpText);
  }

  @Test
  void testDisplayHP5() {
    UI ui = new UI(window);
    Player.setHealth(0); // Set the player's health to 75
    String hpText = ui.displayHP();
    assertEquals("0", hpText);
  }

  @Test
  void testDisplayCoins1() {
    UI ui = new UI(window);
    Player.setCoins(15); // Set the player's coins to 15
    String coinsText = ui.displayCoins();
    assertEquals("15", coinsText);
  }

  @Test
  void testDisplayCoins2() {
    UI ui = new UI(window);
    Player.setCoins(0); // Set the player's coins to 15
    String coinsText = ui.displayCoins();
    assertEquals("0", coinsText);
  }

  @Test
  void testDisplayCoins3() {
    UI ui = new UI(window);
    Player.setCoins(20); // Set the player's coins to 15
    String coinsText = ui.displayCoins();
    assertEquals("20", coinsText);
  }

  @Test
  void testDisplayCoins4() {
    UI ui = new UI(window);
    Player.setCoins(200); // Set the player's coins to 15
    String coinsText = ui.displayCoins();
    assertEquals("200", coinsText);
  }

  @Test
  void testDisplayCoins5() {
    UI ui = new UI(window);
    Player.setCoins(10); // Set the player's coins to 15
    String coinsText = ui.displayCoins();
    assertEquals("10", coinsText);
  }
}
