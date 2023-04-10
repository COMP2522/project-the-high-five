package org.bcit.comp2522.project;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static processing.core.PApplet.dist;

import processing.core.PImage;

/**
 * This class represents the towers in the game
 * Contains attributes and methods each tower object should have.
 *
 * @author gursidhsandhu
 * @version 1.0
 */
public class Tower extends Sprite implements Collidable {

  private PImage towerSprite1;
  private PImage towerWeapon1;
  private PImage[] towerWeaponSprites = new PImage[6];


  // this ensures every tower is same size
  private final int baseSize = 40;

  private int timer;

  private boolean inRange = false;
  private Enemy tracking;

  private boolean standby;

  private int spriteIndex = 0;

  private BulletManager bulletManager;

  private int size = 24;


  // These two variables represent the center of the tower
  float centerX = getXpos() + (baseSize / 2);
  float centerY = getYpos() - (baseSize / 2);
  float radius = findRadius();


  /**
   * Constructor of a tower object.
   *
   * @param xpos          represents x position of a tower.
   * @param ypos          represents y position of a tower.
   * @param window        represents the window it is drawn on.
   * @param bulletManager represents an array of bullets.
   */
  public Tower(float xpos, float ypos, Window window, BulletManager bulletManager) {
    super(xpos, ypos, window);
    towerSprite1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Tower1e.png");
    towerWeapon1 = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Tower 06 "
            + "- Level 01 - Weapon.png");
    this.bulletManager = bulletManager;
    radius = 100;
    tracking = null;
    standby = true;
    loadWeaponSprite1();
  }

  /**
   * Method that loads the towers weapon based on towers position and size.
   */
  public void loadWeaponSprite1() {
    int spriteWidth = 64;
    int spriteHeight = 64;
    for (int i = 0; i < towerWeaponSprites.length; i++) {
      int x = (i % towerWeaponSprites.length) * spriteWidth;
      towerWeaponSprites[i] = towerWeapon1.get(x, 0, spriteWidth, spriteHeight);
    }
  }


  /**
   * Method that draws a tower based on position and image size.
   */
  public void draw() {

    window.pushStyle();
    window.strokeWeight(2);

    if (!standby) {
      timer++;
      window.image(towerWeaponSprites[spriteIndex], getXpos() - 7, getYpos() - 89 + 48);
    } else {
      window.image(towerWeaponSprites[0], getXpos() - 7, getYpos() - 89 + 48);
    }

    drawSprite();
    window.image(towerSprite1, getXpos(), getYpos() - 48, 48, 96);
    window.image(towerWeaponSprites[spriteIndex], getXpos() - 7, getYpos() - 41);
    window.noFill();

    window.popStyle();
  }

  /**
   * This method controls the animation of the tower's weapon.
   */
  public void drawSprite() {
    if (standby) {
      spriteIndex = 0;
    } else {
      if (timer % 10 == 0) {
        if (spriteIndex >= towerWeaponSprites.length - 1) {
          spriteIndex = 0;
        } else {
          spriteIndex++;
        }
      }
    }
  }


  // This variable will be used in the method below
  float maxDistance = 0;


  /**
   * Method that calculates the radius around a tower based on its position.
   *
   * @return radius variable value.
   */
  public float findRadius() {

    // first check all the 4 corners of the square one by one
    for (int i = 0; i < 4; i++) {
      float x = getXpos() + (i % 2) * baseSize;
      float y = getYpos() + (i / 2) * baseSize;
      float distance = dist(centerX, centerY, x, y);

      if (distance > maxDistance) {
        maxDistance = distance;
      }
    }

    // now check all the corners of the rectangle
    for (int i = 0; i < 4; i++) {
      float x = getXpos() + (i % 2) * baseSize / 2;
      float y = getYpos() - baseSize / 4 + (i / 2) * baseSize / 2;
      float distance = dist(centerX, centerY, x, y);

      if (distance > maxDistance) {
        maxDistance = distance;
      }

    }

    // finally check all 3 points of the triangle
    // for the triangle it is easier to just have a condition that matches to each point
    for (int i = 0; i < 3; i++) {

      float x;
      float y;

      switch (i) {

        // first point
        case 0:
          x = getXpos() + baseSize / 4;
          y = (float) (getYpos() - baseSize * 1.5);
          break;

        // second point
        case 1:
          x = getXpos() + baseSize / 2;
          y = (float) (getYpos() - (baseSize * 1.5) - (baseSize / 2));
          break;

        // third point
        default:
          x = getXpos() + baseSize - (baseSize / 4);
          y = (float) (getYpos() - baseSize * 1.5);
      }

      float distance = dist(centerX, centerY, x, y);

      if (distance > maxDistance) {
        maxDistance = distance;
      }

    }

    float radius = maxDistance;
    // this is now the radius around the tower
    return maxDistance;

  }

  /**
   * Method that uses distance and radius to check if a collision has occurred.
   *
   * @param other represents incoming object.
   * @return true or false.
   */
  @Override
  public boolean collide(Object other) {
    if (other instanceof Enemy) {
      Enemy enemy = (Enemy) other;
      double distanceTwo = sqrt(pow(enemy.getXpos() - this.centerX, 2)
              + pow(enemy.getYpos() - this.centerY, 2));
      double distance1 = dist(enemy.getXpos(), enemy.getYpos(), getXpos() + size, getYpos() + size);
      if (distance1 <= radius) {
        shoot();
        return true;
      }
    }
    return false;
  }

  /**
   * This method uses the 3 methods below it and combines it all together.
   * Basically checks if a tower should be shooting an enemy based on position.
   *
   * @param enemyManager represents an array of enemies.
   */
  public void shootingEnemy(EnemyManager enemyManager) {
    for (Enemy enemy : enemyManager.getEnemies()) {
      inRange(enemy);
      if (inRange) {
        track(enemy);
        shoot();
        break;
      }
    }
  }

  /**
   * Method that shoots a bullet object towards an enemies tracked position based on timing as well.
   */
  public void shoot() {
    if (timer % 60 == 0) {
      standby = true;
      timer = 0;
      if (tracking != null) {
        float angle = window.atan2(tracking.getYpos() - getYpos(), tracking.getXpos() - getXpos());
        bulletManager.addBullet(new Bullet(getXpos() + size, getYpos() + size, window, angle));
        standby = false;
      }
    }
  }

  /**
   * Method that calculates the distance between an enemy and a tower.
   * If the distance is within the radius of the tower, then assign true to the inRange variable.
   *
   * @param enemy represents one enemy.
   */
  public void inRange(Enemy enemy) {
    double distance = dist(enemy.getXpos() + size, enemy.getYpos() + size, getXpos(), getYpos());
    if (distance <= radius) {
      inRange = true;
    } else {
      inRange = false;
      tracking = null;
    }
  }

  /**
   * Getter method for inRange variable that is assigned a value above.
   *
   * @return the value.
   */
  public boolean isInRange() {
    return inRange;
  }


  /**
   * This method tracks the enemy that is closest to the tower ( sets priority ).
   *
   * @param enemy represents one enemy
   */
  public void track(Enemy enemy) {
    float distance = dist(enemy.getXpos() + size, enemy.getYpos() + size, getXpos(), getYpos());
    if (distance <= radius) {
      if (tracking != null) {
        if (enemy.getXpos() > tracking.getXpos()) {
          tracking = enemy;
        }
      } else {
        tracking = enemy;
      }
    }
  }

}
