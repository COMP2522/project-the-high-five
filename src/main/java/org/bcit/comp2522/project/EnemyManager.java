package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Class that manages all the enemies in the game.
 * It contains an ArrayList of enemies and methods to set up and initialize them.
 */
public class EnemyManager {
  private final ArrayList<Enemy> enemies;
  private final Window window;
  private static int enemiesKilled = 0;
  private static int levelCompleted = 0;

  /**
   * Constructs an EnemyManager object with a Window object.
   *
   * @param window the Window object to associate with the EnemyManager
   */
  public EnemyManager(Window window) {
    this.window = window;
    enemies = new ArrayList<>();
  }

  public static int getEnemiesKilled() {
    return enemiesKilled;
  }

  public static void setEnemiesKilled(int enemiesKilled) {
    EnemyManager.enemiesKilled = enemiesKilled;
  }

  public static int getLevelCompleted() {
    return levelCompleted;
  }

  public static void setLevelCompleted(int levelCompleted) {
    EnemyManager.levelCompleted = levelCompleted;
  }

  public void addEnemy(Enemy enemy){
    enemies.add(enemy);
  }

  public void removeEnemy(){
    for (Enemy enemy : enemies) {
      if (enemy.getIsDead()) {
        enemies.remove(enemy);
        break;
      }
    }
  }
  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public void update(BulletManager bulletManager) {
    for (Enemy enemy : enemies) {
      enemy.draw();
      enemy.move();
      enemy.outOfBounds();
      if (enemiesKilled == 20) {
        enemiesKilled = 0;
        window.levelManager.nextLevel();
        levelCompleted++;
      }
      if (levelCompleted == 5) {
        window.levelManager.killEnemies();
      }
      for (Bullet bullet : bulletManager.bullets) {
        if (enemy.collide(bullet)) {
          bullet.setIsHit(true);
        }
      }
    }
    removeEnemy();
  }
}
