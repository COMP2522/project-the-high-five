package org.bcit.comp2522.project;

import processing.core.PImage;

/**
 * The Enemy class extends the Sprite class and implements the Collidable interface to specify
 * attributes for enemies in a game. An Enemy has health, x and y velocities, and follows a Path.
 * Enemies can collide with other Collidable objects.
 *
 * @author quintessential quintuplets
 * @version 1.0
 */
public class Enemy extends Sprite implements Collidable, Movable {
  private int health;
  private int vx;
  private int vy;
  private int size = 55;
  private final int originalVx;
  private final int originalVy;
  private final Path path;
  public int spriteIndex = 0;
  public int spriteTimer = 0;
  private final int spriteLength;
  private final int damage;
  public PImage enemySprite;
  public PImage[] enemySprites = new PImage[8];
  public PImage[] enemySpritesUP = new PImage[8];
  public PImage[] enemySpritesDOWN = new PImage[8];
  private Node currentNode;
  public int direction = 0;
  private boolean isDead = false;
  EnemyManager enemyManager;

  /**
   * Constructor for creating a new Enemy.
   *
   * @param xpos   the x-coordinate of the Enemy
   * @param ypos   the y-coordinate of the Enemy
   * @param window the Window that the Enemy is in
   * @param health the health of the Enemy
   * @param vx     the x-velocity of the Enemy
   * @param vy     the y-velocity of the Enemy
   * @param damage the damage the Enemy deals to the Player
   */
  public Enemy(float xpos, float ypos, Window window, int health,
               int vx, int vy, int damage, Level level) {
    super(xpos, ypos, window);
    this.health = health;
    this.vx = vx;
    this.vy = vy;
    this.damage = damage;
    originalVx = vx;
    originalVy = vy;
    path = level.getPath();
    spriteLength = 8;
    currentNode = path.getHead();
    enemyManager = new EnemyManager(window);
  }

  /**
   * Sets the size of the Enemy.
   *
   * @param size the health of the Enemy
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Returns the length of Spite.
   *
   * @return the length of Sprite
   */
  public int getSpriteLength() {
    return spriteLength;
  }

  /**
   * Returns boolean value of whether the Enemy is dead.
   *
   * @return boolean value of whether the Enemy is dead
   */
  public boolean getIsDead() {
    return isDead;
  }

  /**
   * Removes the Enemy from the game when out of bounds.
   */
  public void outOfBounds() {
    if (getXpos() > window.width) {
      isDead = true;
      Player.setHealth(Player.getHealth() - damage);
    }
  }

  /**
   * Loads the sprite images for the Enemy.
   */
  public void loadSprite() {
    int spriteWidth = 64;
    int spriteHeight = 64;
    int upY = 256;
    int downY = 192;
    int rightY = 320;
    for (int i = 0; i < spriteLength; i++) {
      int x = i % spriteLength * spriteWidth;
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
    if (spriteTimer >= spriteLength) {
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
    window.popStyle();
  }

  /**
   * Updates the position of the Enemy.
   * The Enemy follows the Path, changing its velocity as necessary to move towards the next
   * Node on the Path.
   */
  public void move() {
    //currentNode = path.getHead();
    if (getXpos() == currentNode.getXpos() && getYpos() == currentNode.getYpos()) {
      if (currentNode.next != null) {
        if (currentNode.next.getXpos() > currentNode.getXpos()) {
          // go right, direction = 0;
          vx = originalVx;
          vy = 0;
          direction = 0;
        } else if (currentNode.next.getXpos() < currentNode.getXpos()) {
          // go left, direction = 3;
          vx = originalVx * -1;
          vy = 0;
        } else if (currentNode.next.getYpos() > currentNode.getYpos()) {
          // go down, direction = 1;
          vx = 0;
          vy = originalVy;
          direction = 1;
        } else if (currentNode.next.getYpos() < currentNode.getYpos()) {
          // go up , direction = 2;
          vx = 0;
          vy = originalVy * -1;
          direction = 2;
        }
        currentNode = currentNode.next;
      }

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
    if (other instanceof Bullet bullet) {
      if (getXpos() < bullet.getXpos() + bullet.getSize()
              && getXpos() + size > bullet.getXpos()
              && getYpos() < bullet.getYpos() + bullet.getSize()
              && getYpos() + size > bullet.getYpos()) {
        health -= bullet.getDamage();
        if (health <= 0) {
          enemyManager.setEnemiesKilled(EnemyManager.getEnemiesKilled() + 1);
          isDead = true;
          Player.setCoins(Player.getCoins() + (2 + damage));
          Player.setCoins(Player.getCoins() + damage);
          Player.setCurrentScore(Player.getCurrentScore()
                  + ((Player.getHealth() * damage * Player.getCoins() / 10)));
        }
        return true;
      }
    }
    return false;
  }
}
