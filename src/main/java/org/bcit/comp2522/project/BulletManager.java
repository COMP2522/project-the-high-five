package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * BulletManager.java
 * Manages the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class BulletManager {

  // array of bullets
  private final ArrayList<Bullet> bullets;

  private final Window window;

    /**
     * Constructs a BulletManager object with a Window object.
     *
     * @param window the Window object to associate with the BulletManager
     */
  public BulletManager(Window window) {
    this.window = window;
    bullets = window.bullets;
  }

  /**
   * Updates the bullets in the game.
   *
   */
//  public void remove(Bullet bullet) {
//    if (bullet.getXpos() >= window.width || bullet.getYpos() >= window.height) {
//      bullets.remove(bullet);
//    } else if (bullet.getXpos() <= 0 || bullet.getYpos() <= 0) {
//      bullets.remove(bullet);
//    }
//    for (Enemy enemy : window.enemies) {
//      if (bullet.collide(enemy)) {
//          bullets.remove(bullet);
//      }
//    }
//  }
}
