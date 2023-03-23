package org.bcit.comp2522.project;

/**
 * Class that specifies what attributes enemies should contain.
 *
 * @author Victor Vasconcellos
 * @version 1.0
 */
public class Enemy extends Sprite implements Collidable{
  private int health;
  private float vx;
  private float vy;
  float originalVX = vx;
  float originalVY = vy;
  private Path path;
  public Enemy(float xpos, float ypos, Window window, int health, float vx, float vy) {
    super(xpos, ypos, window);
    this.health = health;
    this.vx = vx;
    this.vy = vy;
    originalVX = vx;
    originalVY = vy;
    path = window.path;
  }

//  Enemy boss = new Enemy(0, 180, window, 100, 1f, 1f);
//  Enemy regular = new Enemy(0, 180, window, 50, 3, 3);
//  Enemy fast = new Enemy(0, 180, window, 25, 5, 5);

  public void update(){
    Node current = path.getHead();
    while (current != null) {
      if (getXpos() == current.getXpos() && getYpos() == current.getYpos()) {
        if (current.next != null) {
          // go right
          if (current.next.getXpos() > current.getXpos()) {
            vx = originalVX;
            vy = 0;
          }
          // go left
          else if (current.next.getXpos() < current.getXpos()) {
            vx = originalVX * -1;
            vy = 0;
          }
          // go down
          else if (current.next.getYpos() > current.getYpos()) {
            vx = 0;
            vy = originalVY;
          }
          // go up
          else if (current.next.getYpos() < current.getYpos()) {
            vx = 0;
            vy = originalVY * -1;
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
        health -= 1;
        return true;
      }
    }
    return false;
  }

}
