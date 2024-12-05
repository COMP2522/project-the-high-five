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

  /* The list of bullets. */
  final ArrayList<Bullet> bullets;
  /* The window the bullets are in. */
  private final Window window;

  /**
   * Constructs a BulletManager object with a Window object.
   *
   * @param window the Window object to associate with the BulletManager
   */
  public BulletManager(Window window) {
    this.window = window;
    bullets = new ArrayList<>();
  }

  /**
   * Adds a bullet to the list of bullets.
   *
   * @param bullet the bullet to add
   */
  public void addBullet(Bullet bullet) {
    bullets.add(bullet);
  }

  /**
   * Removes a bullet from the list of bullets.
   * If a bullet has hit a target or is out of bounds, it is removed.
   */
  public void removeBullet() {
    for (Bullet bullet : bullets) {
      if (bullet.getIsHit()) {
        bullets.remove(bullet);
        break;
      } else if (bullet.getXpos() >= window.width || bullet.getXpos() <= 0
              || bullet.getYpos() >= window.height || bullet.getYpos() <= 0) {
        bullets.remove(bullet);
        break;
      }
    }
  }

  /**
   * Updates the state of all bullets in the list.
   * Moves and draws the bullets, and removes any bullets that have hit or is out of bounds.
   */
  public void update() {
    for (Bullet bullet : bullets) {
      bullet.move();
      bullet.draw();
    }
    removeBullet();
  }
}
