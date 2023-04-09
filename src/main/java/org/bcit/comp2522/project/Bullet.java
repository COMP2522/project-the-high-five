package org.bcit.comp2522.project;

/**
 * Bullet.java
 * Represents the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class Bullet extends Sprite {

  /* The speed of the bullet. */
  private int speed;
  /* The size of the bullet. */
  private int size;
  /* The angle of the bullet. */
  private float angle;
  /* The damage of the bullet. */
  private int damage = 1;
  /* Whether the bullet has hit a target. */
  private boolean isHit = false;

  /**
   * Constructs a Bullet object.
   *
   * @param xpos   The x position of the bullet.
   * @param ypos   The y position of the bullet.
   * @param window The window the bullet is in.
   * @param angle  The angle of the bullet.
   */
  public Bullet(float xpos, float ypos, Window window, float angle) {
    super(xpos, ypos, window);
    this.speed = 10;
    this.size = 10;
    this.angle = angle;
  }

  /**
   * Returns the damage of the bullet.
   *
   * @return the damage of the bullet.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the size of the bullet.
   *
   * @return the size of the bullet.
   */
  public int getSize() {
    return size;
  }

  /**
   * Moves the bullet.
   */
  public void move() {
    setXpos(getXpos() + (float) (speed * Math.cos(angle)));
    setYpos(getYpos() + (float) (speed * Math.sin(angle)));
  }

  /**
   * Draws the bullet.
   */
  public void draw() {
    window.fill(0, 0, 255);
    window.circle(getXpos(), getYpos(), 10);
  }

  /**
   * Returns whether the bullet has hit a target.
   *
   * @return whether the bullet has hit a target.
   */
  public boolean getIsHit() {
    return isHit;
  }

  /**
   * Sets whether the bullet has hit a target.
   *
   * @param isHit whether the bullet has hit a target.
   */
  public void setIsHit(boolean isHit) {
    this.isHit = isHit;
  }
}
