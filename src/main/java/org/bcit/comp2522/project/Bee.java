package org.bcit.comp2522.project;

/**
 * Class that represents a variant of an enemy.
 *
 * @author quintessential quintuplets
 * @version 1.0
 */
public class Bee extends Enemy {

  /**
   * Constructor of this class.
   *
   * @param x      represents x position.
   * @param y      represents y position.
   * @param window represents the window it is displayed on.
   * @param health represents the Bee's health.
   * @param speed  represents the Bee's speed.
   * @param damage represents the Bee's damage level.
   * @param reward represents the Bee's reward.
   * @param level  represents the level of game.
   */
  public Bee(int x, int y, Window window, int health, int speed, int damage, int reward, Level level) {
    super(x, y, window, health, speed, damage, reward, level);
    enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/firewasp.png");
    loadSpriteBee();
    setSize(80);
  }

  /**
   * Method that controls the animation of the Bee's image.
   */
  private void loadSpriteBee() {
    int spriteWidth = 96;
    int spriteHeight = 96;
    int upY = 96;
    int downY = 0;
    int rightY = 192;
    for (int i = 0; i < getSpriteLength(); i++) {
      int x = i % getSpriteLength() * spriteWidth;
      enemySprites[i] = enemySprite.get(x, rightY, spriteWidth, spriteHeight);
      enemySpritesUP[i] = enemySprite.get(x, upY, spriteWidth, spriteHeight);
      enemySpritesDOWN[i] = enemySprite.get(x, downY, spriteWidth, spriteHeight);
    }
  }

  /**
   * Method that draws out the image of a Bee variant enemy.
   */
  public void draw() {
    window.pushStyle();
    // Sprite animation timer
    if (spriteTimer >= getSpriteLength()) {
      if (spriteIndex >= getSpriteLength() - 1) {
        spriteIndex = 0;
      } else {
        spriteIndex++;
      }
      spriteTimer = 0;
    }

    spriteTimer++;
    // Draw sprite based on direction
    if (direction == 0) {
      window.image(enemySprites[spriteIndex], getXpos(), getYpos() - 20, 80, 80);
    } else if (direction == 2) {
      window.image(enemySpritesUP[spriteIndex], getXpos() - 20, getYpos(), 80, 80);
    } else if (direction == 1) {
      window.image(enemySpritesDOWN[spriteIndex], getXpos() - 20, getYpos(), 80, 80);
    }
    window.popStyle();
  }
}
