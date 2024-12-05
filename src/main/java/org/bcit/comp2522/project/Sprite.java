package org.bcit.comp2522.project;

/**
 * An abstract class that represents a sprite in the game.
 */
public abstract class Sprite implements Drawable {
  /* The x and y coordinates of the sprite. */
  private float xpos;
  private float ypos;
  /* The window that the sprite is in. */
  protected final Window window;

  /**
   * Constructor for creating a new Sprite.
   *
   * @param xpos   the x-coordinate of the Sprite
   * @param ypos   the y-coordinate of the Sprite
   * @param window the Window that the Sprite is in
   */
  public Sprite(float xpos, float ypos, Window window) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.window = window;
  }

  /**
   * Gets the x coordinate of the sprite.
   *
   * @return the x coordinate of the sprite
   */
  public float getXpos() {
    return xpos;
  }

  /**
   * Gets the y coordinate of the sprite.
   *
   * @return the y coordinate of the sprite
   */
  public float getYpos() {
    return ypos;
  }

  /**
   * Sets the x coordinate of the sprite.
   *
   * @param x the new x coordinate of the sprite
   */
  public void setXpos(float x) {
    xpos = x;
  }

  /**
   * Sets the y coordinate of the sprite.
   *
   * @param y the new y coordinate of the sprite
   */
  public void setYpos(float y) {
    ypos = y;
  }

  /**
   * Draws the elements in the window.
   */
  public void draw() {
  }
}
