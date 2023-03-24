package org.bcit.comp2522.project;

/**
 * The Enemy class extends the Sprite class and implements the Collidable interface to specify
 * attributes for enemies in a game. An Enemy has health, x and y velocities, and follows a Path.
 * Enemies can collide with other Collidable objects.
 *
 * @author Victor Vasconcellos
 * @version 1.0
 */
public class Enemy extends Sprite implements Collidable, Movable {
  private int health;
  private int vx;
  private int vy;
  private final int size;
  private final int originalVx;
  private final int originalVy;
  private final Path path;

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * Constructor for creating a new Enemy.
   *
   * @param xpos the x-coordinate of the Enemy
   * @param ypos the y-coordinate of the Enemy
   * @param window the Window that the Enemy is in
   * @param health the health of the Enemy
   * @param vx the x-velocity of the Enemy
   * @param vy the y-velocity of the Enemy
   * @param size the size of the Enemy
   */
  public Enemy(float xpos, float ypos, Window window, int health, int vx, int vy, int size) {
    super(xpos, ypos, window);
    this.health = health;
    this.vx = vx;
    this.vy = vy;
    this.size = size;
    originalVx = vx;
    originalVy = vy;
    path = window.path;
  }

  /**
   * Draws the elements in the window.
   */
  public void draw() {
    window.pushStyle();
    window.ellipse(getXpos(), getYpos(), size, size);
    window.popStyle();
  }

  /**
   * Updates the position of the Enemy.
   * The Enemy follows the Path, changing its velocity as necessary to move towards the next
   * Node on the Path.
   */
  public void move() {
    Node current = path.getHead();
    while (current != null) {
      if (getXpos() == current.getXpos() && getYpos() == current.getYpos()) {
        if (current.next != null) {
          if (current.next.getXpos() > current.getXpos()) {
            // go right
            vx = originalVx;
            vy = 0;
          } else if (current.next.getXpos() < current.getXpos()) {
            // go left
            vx = originalVx * -1;
            vy = 0;
          } else if (current.next.getYpos() > current.getYpos()) {
            // go down
            vx = 0;
            vy = originalVy;
          } else if (current.next.getYpos() < current.getYpos()) {
            // go up
            vx = 0;
            vy = originalVy * -1;
          }
        }
      }
      current = current.next;
    }
    setXpos(getXpos() + vx);
    setYpos(getYpos() + vy);
  }

  /**
   * Determines if the Enemy has collided with another Collidable object.
   *
   * @param other the Collidable object that the Enemy may have collided with
   * @return true if the Enemy has collided with the other Collidable object, false otherwise
   */
  @Override
  public boolean collide(Collidable other) {
    if (other instanceof Bullet) {
      if (this.getXpos() == other.getXpos() && this.getYpos() == other.getYpos()) {
        health -= 1;
        return true;
      }
    }
    return false;
  }
}
