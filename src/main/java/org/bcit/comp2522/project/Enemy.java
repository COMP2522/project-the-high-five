package org.bcit.comp2522.project;

import processing.core.PImage;

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
  private int spriteIndex = 0;
  private int spriteTimer = 0;
  private PImage enemySprite;
  private PImage[] enemySprites = new PImage[8];

  private PImage[] enemySpritesUP = new PImage[8];

  private PImage[] enemySpritesDOWN = new PImage[8];

  private int direction = 0;

  private boolean isDead = false;

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
  public Enemy(float xpos, float ypos, Window window, int health, int vx, int vy, int size, Level level) {
    super(xpos, ypos, window);
    this.health = health;
    size = 50;
    this.vx = vx;
    this.vy = vy;
    this.size = size;
    originalVx = vx;
    originalVy = vy;
    path = level.getPath();
    enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Clampbeetle3.png");
    loadSprite();
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public boolean getIsDead() {
    return isDead;
  }
  // Remove enemy when out of bounds
  public void outOfBounds() {
    if (getXpos() > window.width) {
      isDead = true;
      Player.getInstance().setHealth(Player.getInstance().getHealth() - size);
    }
  }

  public void loadSprite(){
    int spriteWidth = 64;
    int spriteHeight = 64;
    int spriteLength = 8;
    int upY = 256;
    int downY = 192;
    int rightY = 320;
    for (int i = 0; i < spriteLength; i++) {
      int x = i%spriteLength * spriteWidth;
      enemySprites[i] = enemySprite.get(x, rightY, spriteWidth, spriteHeight);
      enemySpritesUP[i] = enemySprite.get(x, upY, spriteWidth, spriteHeight);
      enemySpritesDOWN[i] = enemySprite.get(x, downY, spriteWidth, spriteHeight);
    }


  }

  /**
   * Draws the elements in the window.
   */
  public void draw() {
    window.pushStyle();
    // Sprite animation timer
    if (spriteTimer >= 8) {
      if (spriteIndex >= enemySprites.length - 1) {
        spriteIndex = 0;
      } else {
        spriteIndex++;
      }
      spriteTimer = 0;
    }

    spriteTimer++;
    // Draw sprite based on direction
    if (direction == 0) {
      window.image(enemySprites[spriteIndex], getXpos(), getYpos(), size, size);
    } else if (direction == 2) {
      window.image(enemySpritesUP[spriteIndex], getXpos(), getYpos(), size, size);
    } else if (direction == 1) {
      window.image(enemySpritesDOWN[spriteIndex], getXpos(), getYpos(), size, size);
    }
    //window.image(enemySprites[spriteIndex], getXpos(), getYpos(), size, size);
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
            // go right, direction = 0;
            vx = originalVx;
            vy = 0;
            direction = 0;
          } else if (current.next.getXpos() < current.getXpos()) {
            // go left
            vx = originalVx * -1;
            vy = 0;
          } else if (current.next.getYpos() > current.getYpos()) {
            // go down, direction = 1;
            vx = 0;
            vy = originalVy;
            direction = 1;
          } else if (current.next.getYpos() < current.getYpos()) {
            // go up , direction = 2;
            vx = 0;
            vy = originalVy * -1;
            direction = 2;
          }
        }
      }
      current = current.next;
    }
    setXpos(getXpos() + vx);
    setYpos(getYpos() + vy);
  }
  public void move2() {
    Node current = path.getHead();
    if (current.next != null) {
      if (current.next.getXpos() > current.getXpos()) {
        // go right, direction = 0;
        vx = originalVx;
        vy = 0;
        direction = 0;
      } else if (current.next.getXpos() < current.getXpos()) {
        // go left
        vx = originalVx * -1;
        vy = 0;
      } else if (current.next.getYpos() > current.getYpos()) {
        // go down, direction = 1;
        vx = 0;
        vy = originalVy;
        direction = 1;
      } else if (current.next.getYpos() < current.getYpos()) {
        // go up , direction = 2;
        vx = 0;
        vy = originalVy * -1;
        direction = 2;
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
  public boolean collide(Object other) {
    if (other instanceof Bullet) {
        Bullet bullet = (Bullet) other;
        if (getXpos() < bullet.getXpos() + bullet.getSize()
            && getXpos() + size > bullet.getXpos()
            && getYpos() < bullet.getYpos() + bullet.getSize()
            && getYpos() + size > bullet.getYpos()) {
            health -= bullet.getDamage();
            if (health <= 0) {
            isDead = true;
            Player.getInstance().setCoins(Player.getInstance().getCoins() + size);
            }
            return true;
        }
    }
    return false;
  }
}
