package org.bcit.comp2522.project;

/**
 * Bullet.java
 * Represents the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class Bullet extends Sprite {

  public int getSpeed() {
    return speed;
  }

  private final int speed;

  private final int size;

  private final float angle;

  public int getDamage() {
    return damage;
  }

  private final int damage = 1;

  private boolean isHit = false;

  public Bullet(float xpos, float ypos, Window window, float angle) {
    super(xpos, ypos, window);
    this.speed = 10;
    this.size = 10;
    this.angle = angle;
  }

  public int getSize() {
    return size;
  }

  public void move() {
    setXpos(getXpos() + (float) (speed * Math.cos(angle)));
    setYpos(getYpos() + (float) (speed * Math.sin(angle)));
  }

  public void draw() {
    window.fill(0, 0, 255);
    window.circle(getXpos(), getYpos(), 10);
  }

  public boolean getIsHit() {
    return isHit;
  }

  public void setIsHit(boolean isHit) {
    this.isHit = isHit;
  }
}