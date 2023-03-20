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
  public Enemy(float xpos, float ypos, Window window) {
    super(xpos, ypos, window);
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
