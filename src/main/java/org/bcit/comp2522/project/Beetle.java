package org.bcit.comp2522.project;

public class Beetle extends Enemy{
  public Beetle(int x, int y, Window window, int health, int speed, int damage, int reward, Level level) {
      super(x, y, window, health, speed, damage, reward, level);
      enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/Clampbeetle3.png");
      loadSpriteBeetle();
  }

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
