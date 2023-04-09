package org.bcit.comp2522.project;

/**
 * Class that represents a variant of an Enemy.
 * @author quintessential quintuplets
 * @version 1.0
 */
public class Beetle extends Enemy{

  /**
   * Constructor of this class.
   * @param x represents x position.
   * @param y represents y position.
   * @param window represents the window it is displayed on.
   * @param health represents the Beetle's health.
   * @param speed represents the Beetle's speed.
   * @param damage represents the Beetle's damage level.
   * @param reward represents the Beetle's reward.
   * @param level represents the level of game.
   */
  public Beetle(int x, int y, Window window, int health, int speed, int damage, int reward, Level level) {
      super(x, y, window, health, speed, damage, reward, level);
      enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Clampbeetle3.png");
      loadSpriteBeetle();
  }

  /**
   * Method that controls the animation of the Beetle's image.
   */
  private void loadSpriteBeetle(){
    int spriteWidth = 64;
    int spriteHeight = 64;
    int upY = 256;
    int downY = 192;
    int rightY = 320;
    for (int i = 0; i < getSpriteLength(); i++) {
      int x = i%getSpriteLength() * spriteWidth;
      enemySprites[i] = enemySprite.get(x, rightY, spriteWidth, spriteHeight);
      enemySpritesUP[i] = enemySprite.get(x, upY, spriteWidth, spriteHeight);
      enemySpritesDOWN[i] = enemySprite.get(x, downY, spriteWidth, spriteHeight);
    }
  }
}
