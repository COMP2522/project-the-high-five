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

  private int speed = 5;

  public int getDamage() {
    return damage;
  }

  private int damage = 1;

  public Bullet(float xpos, float ypos, Window window) {
    super(xpos, ypos, window);
  }

  public void move() {

  }

  public void draw() {
    window.fill(0, 255, 0);
    window.circle(getXpos(), getYpos(), 10);
  }


}