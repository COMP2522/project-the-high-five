package org.bcit.comp2522.project;

import java.util.ArrayList;

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
    enemies = window.enemies;
  }

  public void remove(Enemy enemy){
    if (enemy.getXpos() >= window.width || enemy.getYpos() >= window.height) {
      enemies.remove(enemy);
    }
  }

  public void update(Enemy enemy) {
      enemy.draw();
      enemy.move();
      remove(enemy);
  }
}
