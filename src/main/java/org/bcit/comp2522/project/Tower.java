package org.bcit.comp2522.project;

/**
 * This class represents the towers in the game
 * Contains attributes and methods each tower
 * object should have
 * @author gursidhsandhu
 * @version 2023
 */
public class Tower extends Sprite{
// methods unique to this class

  /**
   * Constructor for tower class
   * @param xpos
   * @param ypos
   * @param window
   */
  public Tower(float xpos, float ypos, Window window){
    super(xpos, ypos, window);
  }
  private int attackRate;
  private int range;

  public void shoot(){}

  public void draw(){}

  public void collide(){}
}
