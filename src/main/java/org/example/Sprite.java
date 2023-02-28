package org.example;

import java.awt.Color;
import processing.core.PVector;


public class Sprite {
  private PVector position;
  private PVector direction;
  private float size;
  private final float speed;
  private final Color color;
  private final Window window;

  public Sprite(PVector position, PVector direction, float size,
                float speed, Color color, Window window) {
    this.position = position;
    this.direction = direction;
    this.size = size;
    this.speed = speed;
    this.window = window;
    this.color = color;
  }

  public Window getWindow() {
    return window;
  }

  public Color getColor() {
    return color;
  }

  /**
   * Draws the elements in the window.
   */
  public void draw() {
    window.pushStyle();
    window.fill(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    window.ellipse(this.position.x, this.position.y, size, size);
    window.popStyle();
  }
}