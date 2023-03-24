package org.bcit.comp2522.project;

import java.awt.*;
import processing.core.PVector;

/**
 * Class that specifies what attributes enemies should contain.
 *
 * @author Victor Vasconcellos
 * @version 1.0
 */
public class Enemy extends Sprite implements Collidable{

  int vx;
  int vy;
  int speed;
  Path path;
  public Enemy(float xpos, float ypos, Window window) {
    super(xpos, ypos, window);
    speed = 3;
    path = window.path;
  }

//  public void draw() {
//    float size = 50;
//    window.pushStyle();
//    window.fill(255, 0, 0);
//    window.ellipse(getXpos(), getYpos(), size, size);
//    window.popStyle();
//  }

  public void update(){
    int i = 0;
    Node current = path.getHead();
    while (current != null) {
      if (getXpos() == current.getXpos() && getYpos() == current.getYpos()) {
        if (current.next != null) {
          if (current.next.getXpos() > current.getXpos()) {
            vx = speed;
            vy = 0;
          } else if (current.next.getXpos() < current.getXpos()) {
            vx = -speed;
            vy = 0;
          } else if (current.next.getYpos() > current.getYpos()) {
            vx = 0;
            vy = speed;
          } else if (current.next.getYpos() < current.getYpos()) {
            vx = 0;
            vy = -speed;
          }
        }
      }
      current = current.next;
    }
    setXpos(getXpos() + vx);
    setYpos(getYpos() + vy);
  }
  @Override
  public boolean collide(Collidable other) {
    if (other instanceof Bullet) {
      if (this.getXpos() == other.getXpos() && this.getYpos() == other.getYpos()) {
        return true;
      }
    }
    return false;
  }
}
