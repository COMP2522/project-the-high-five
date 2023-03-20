package org.bcit.comp2522.project;

/**
 * This class represents the towers in the game
 * Contains attributes and methods each tower
 * object should have
 * @author gursidhsandhu
 */
public class Tower extends Sprite implements Collidable {
// methods unique to this class
  private int attackRate;
  private int range;

  public Tower(float xpos, float ypos, Window window) {
    super(xpos, ypos, window);
  }

  public void shoot(){}

  public void draw(){}

  public void collide(){}

  @Override
  public boolean collide(Collidable other) {
    return false;
  }
}
