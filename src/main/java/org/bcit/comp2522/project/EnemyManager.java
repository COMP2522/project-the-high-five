package org.bcit.comp2522.project;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that manages all the enemies in the game.
 * It contains an ArrayList of enemies and methods to set up and initialize them.
 */
public class EnemyManager {
  private final ArrayList<Enemy> enemies;
  private final Window window;


  /**
   * Constructs an EnemyManager object with a Window object.
   *
   * @param window the Window object to associate with the EnemyManager
   */
  public EnemyManager(Window window) {
    this.window = window;
    this.enemies = new ArrayList<>();
  }

//  /**
//  * Update the position of all the enemies.
//  */
//  public void updateEnemies() {
//    for (Enemy enemy : enemies) {
//      enemy.move();
//    }
//  }

//  /**
//   * Checks if any enemy in the enemies ArrayList collides with another Collidable object.
//   * If a collision is detected, and the enemy's health is 0 or less, the enemy is removed from
//   * the enemies ArrayList and the Window.
//   *
//   * @param other the Collidable object to check for collision with
//   * @return true if a collision is detected, false otherwise
//   */
//  public boolean checkEnemyCollision(Collidable other) {
//    boolean collisionDetected = false;
//    for (int i = enemies.size() - 1; i >= 0; i--) {
//      Enemy enemy = enemies.get(i);
//      if (enemy.collide(other)) {
//        collisionDetected = true;
//        enemy.setHealth(enemy.getHealth() - 1);
//        if (enemy.getHealth() <= 0) {
//          window.removeEnemy(enemy);
//          enemies.remove(i);
//        }
//      }
//    }
//    return collisionDetected;
//  }

}
