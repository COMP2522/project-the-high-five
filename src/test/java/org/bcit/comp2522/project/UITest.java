package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeAll;
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
    LevelManager.setCurrentLevel(0);
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 1", levelText);
  }

  @Test
  void testDisplayLevelNumber2() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(1);
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 2", levelText);
  }

  @Test
  void testDisplayLevelNumber3() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(2);
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 3", levelText);
  }

  @Test
  void testDisplayLevelNumber4() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(3);
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 4", levelText);
  }

  @Test
  void testDisplayLevelNumber5() {
    UI ui = new UI(window);
    LevelManager.setCurrentLevel(4);
    String levelText = ui.displayLevelNumber();
    assertEquals("Level 5", levelText);
  }

  @Test
  void testDisplayScore1() {
    UI ui = new UI(window);
    Player.setCurrentScore(500);
    String scoreText = ui.displayScore();
    assertEquals("Score: 500", scoreText);
  }

  @Test
  void testDisplayScore2() {
    UI ui = new UI(window);
    Player.setCurrentScore(2000);
    String scoreText = ui.displayScore();
    assertEquals("Score: 2000", scoreText);
  }

  @Test
  void testDisplayScore3() {
    UI ui = new UI(window);
    Player.setCurrentScore(769);
    String scoreText = ui.displayScore();
    assertEquals("Score: 769", scoreText);
  }

  @Test
  void testDisplayScore4() {
    UI ui = new UI(window);
    Player.setCurrentScore(17);
    String scoreText = ui.displayScore();
    assertEquals("Score: 17", scoreText);
  }

  @Test
  void testDisplayScore5() {
    UI ui = new UI(window);
    Player.setCurrentScore(3);
    String scoreText = ui.displayScore();
    assertEquals("Score: 3", scoreText);
  }

  @Test
  void testDisplayScore6() {
    UI ui = new UI(window);
    Player.setCurrentScore(0);
    String scoreText = ui.displayScore();
    assertEquals("Score: 0", scoreText);
  }

  @Test
  void testDisplayEnemiesDefeated1() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(10);
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 10", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated2() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(0);
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 0", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated3() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(3);
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 3", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated4() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(4);
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 4", enemiesDefeatedText);
  }

  @Test
  void testDisplayEnemiesDefeated5() {
    UI ui = new UI(window);
    EnemyManager.setEnemiesKilled(20);
    String enemiesDefeatedText = ui.displayEnemiesDefeated();
    assertEquals("Enemies Defeated: 20", enemiesDefeatedText);
  }

  @Test
  void testDisplayHP1() {
    UI ui = new UI(window);
    Player.setHealth(75);
    String hpText = ui.displayHP();
    assertEquals("75", hpText);
  }

  @Test
  void testDisplayHP2() {
    UI ui = new UI(window);
    Player.setHealth(76);
    String hpText = ui.displayHP();
    assertEquals("76", hpText);
  }

  @Test
  void testDisplayHP3() {
    UI ui = new UI(window);
    Player.setHealth(11);
    String hpText = ui.displayHP();
    assertEquals("11", hpText);
  }

  @Test
  void testDisplayHP4() {
    Player.setHealth(7);
    String hpText = ui.displayHP();
    assertEquals("7", hpText);
  }

  @Test
  void testDisplayHP5() {
    Player.setHealth(0);
    String hpText = ui.displayHP();
    assertEquals("0", hpText);
  }

  @Test
  void testDisplayHP6() {
    Player.setHealth(1);
    String hpText = ui.displayHP();
    assertEquals("1", hpText);
  }

  @Test
  void testDisplayHP7() {
    Player.setHealth(9);
    String hpText = ui.displayHP();
    assertEquals("9", hpText);
  }

  @Test
  void testDisplayCoins1() {
    Player.setCoins(15);
    String coinsText = ui.displayCoins();
    assertEquals("15", coinsText);
  }

  @Test
  void testDisplayCoins2() {
    Player.setCoins(0);
    String coinsText = ui.displayCoins();
    assertEquals("0", coinsText);
  }

  @Test
  void testDisplayCoins3() {
    Player.setCoins(20);
    String coinsText = ui.displayCoins();
    assertEquals("20", coinsText);
  }

  @Test
  void testDisplayCoins4() {
    Player.setCoins(200);
    String coinsText = ui.displayCoins();
    assertEquals("200", coinsText);
  }

  @Test
  void testDisplayCoins5() {
    Player.setCoins(10);
    String coinsText = ui.displayCoins();
    assertEquals("10", coinsText);
  }
}
