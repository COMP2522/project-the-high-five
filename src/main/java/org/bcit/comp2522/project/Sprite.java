package org.bcit.comp2522.project;


public abstract class Sprite {


  private final float xpos;
  private final float ypos;
  protected final Window window;

  public Sprite(float xpos, float ypos, Window window) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.window = window;
  }


  /**
   * Draws the elements in the window.
   */
  public void draw() {
    float size = 50;
    window.pushStyle();
    window.ellipse(xpos, ypos, size, size);
    window.popStyle();
  }
}
