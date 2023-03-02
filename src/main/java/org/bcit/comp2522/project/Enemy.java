package org.bcit.comp2522.project;

import java.awt.*;

/**
 * Class that specifies what attributes enemies should contain.
 *
 * @author Victor Vasconcellos
 * @version 2023
 */
public class Enemy extends Sprite {
  int health;
  int speed;

  /**
   * Enemy constructor.
   *
   * @param xpos float x-position
   * @param ypos float y-position
   * @param window window
   * @param health int health
   * @param speed int speed
   */
  public Enemy(float xpos, float ypos, Window window, int health, int speed) {
    super(xpos, ypos, window);
    this.health = health;
    this.speed = speed;
  }

  int size = 5;

  Color color = new Color(255, 0, 0);

  public void draw() {
    window.pushStyle();
    window.fill(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    window.ellipse(this.xpos, this.ypos, size, size);
    window.popStyle();
  }

}
