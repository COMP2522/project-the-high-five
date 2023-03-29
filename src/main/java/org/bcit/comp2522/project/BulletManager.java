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

  private final ArrayList<Bullet> bullets;

  private final Window window;

  public BulletManager(Window window) {
    this.window = window;
    bullets = window.bullets;
  }

  public void remove(Bullet bullet) {
    if (bullet.getXpos() >= window.width || bullet.getYpos() >= window.height) {
      bullets.remove(bullet);
      for (Enemy enemy : window.enemies) {
        if (bullet.collide(enemy)) {
          bullets.remove(bullet);
        }
      }
    }
  }
}
