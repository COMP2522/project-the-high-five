package org.bcit.comp2522.project;

/**
 * Locust class.
 *
 * @author Quan Tran
 */
public class Locust extends Enemy {
  /**
   * Constructs a Locust object.
   *
   * @param x      the x position of the locust
   * @param y      the y position of the locust
   * @param window the window that the locust is drawn on
   * @param health the health of the locust
   * @param speed  the speed of the locust
   * @param damage the damage of the locust
   * @param reward the reward of the locust
   * @param level  the level that the locust is in
   */
  public Locust(int x, int y, Window window, int health,
                int speed, int damage, int reward, Level level) {
    super(x, y, window, health, speed, damage, reward, level);
    enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/locust.png");
    loadSpriteLocust();
  }

  /**
   * Loads the sprite for the locust.
   */
  private void loadSpriteLocust() {
    int spriteWidth = 64;
    int spriteHeight = 64;
    int upY = 64;
    int downY = 0;
    int rightY = 128;
    for (int i = 0; i < getSpriteLength(); i++) {
      int x = i % getSpriteLength() * spriteWidth;
      enemySprites[i] = enemySprite.get(x, rightY, spriteWidth, spriteHeight);
      enemySpritesUP[i] = enemySprite.get(x, upY, spriteWidth, spriteHeight);
      enemySpritesDOWN[i] = enemySprite.get(x, downY, spriteWidth, spriteHeight);
    }
  }


}
