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

  /**
   * Returns the number of enemies that have been killed.
   *
   * @return the number of enemies that have been killed
   */
  public static int getEnemiesKilled() {
    return enemiesKilled;
  }

  /**
   * Sets the number of enemies that have been killed.
   *
   * @param enemiesKilled the number of enemies that have been killed
   */
  public static void setEnemiesKilled(int enemiesKilled) {
    EnemyManager.enemiesKilled = enemiesKilled;
  }

  /**
   * Adds an enemy to the ArrayList of enemies.
   *
   * @param enemy the enemy to be added
   */
  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
  }

  /**
   * Removes an enemy from the ArrayList of enemies.
   */
  public void removeEnemy() {
    for (Enemy enemy : enemies) {
      if (enemy.getIsDead()) {
        enemies.remove(enemy);
        break;
      }
    }
  }

  /**
   * Returns the ArrayList of enemies.
   *
   * @return the ArrayList of enemies
   */
  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  /**
   * Updates the state of the enemies in the game, such as their movement
   * and collisions with bullets.
   *
   * @param bulletManager the BulletManager object used to handle bullets in the game
   */
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
        window.setStage(4);
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
