package org.bcit.comp2522.project;

import processing.core.PVector;

import static processing.core.PApplet.*;

/**
 * Bullet.java
 * Represents the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class Bullet extends Sprite implements Movable, Collidable {

  private int speed = 5;
  private int damage = 1;
  private Enemy target;

  public Bullet(float xpos, float ypos, Window window) {
    super(xpos, ypos, window);
  }

  public void draw() {
    window.fill(0, 255, 0);
    window.ellipse(getXpos(), getYpos(), 10, 10);
  }

  public void setTarget(Enemy target) {
    this.target = target;
  }

//  public void updatePosition() {
//    if (target != null) {
//      PVector direction = new PVector(target.getXpos() - this.getXpos(), target.getYpos() - this.getXpos()y);
//      direction.normalize();
//      direction.mult(5); // Change this value to adjust bullet speed
//      x += direction.x;
//      y += direction.y;
//    }
//  }

  public int track() {
    float minDistance = Float.MAX_VALUE;
    int tracker = -1;
    for (int i = 0; i < window.enemies.size(); i++) {
      Enemy enemy = window.enemies.get(i);
      float distance = dist(getXpos(), getYpos(), enemy.getXpos(), enemy.getYpos());
      if (distance < minDistance) {
        minDistance = distance;
        tracker = i;
      }
    }
    return tracker;
  }


  public void update(int tracker) {
    Enemy enemy = window.enemies.get(tracker);
    float angle = atan2(enemy.getYpos() - getYpos(), enemy.getXpos() - getXpos());
    float speed = 5;
    float dx = cos(angle) * speed;
    float dy = sin(angle) * speed;
    setXpos(getXpos() + dx);
    setYpos(getYpos() + dy);
  }


  public void move() {
    update(track());
  }


  @Override
  public boolean collide(Collidable other) {
    if (other instanceof Enemy) {
      Enemy enemy = (Enemy) other;
      float distance = dist(getXpos(), getYpos(), enemy.getXpos(), enemy.getYpos());
      if (distance < 2) {
        enemy.setHealth(enemy.getHealth() - damage);
        return true;
      }
    }
    return false;
  }
}
