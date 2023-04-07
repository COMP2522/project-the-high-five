package org.bcit.comp2522.project;

import processing.core.PImage;

public class Locust  extends Enemy{
  public Locust(int x, int y, Window window, int health, int speed, int damage, int reward, Level level) {
      super(x, y, window, health, speed, damage, reward, level);
      enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/locust.png");
      loadSpriteLocust();
  }

  private void loadSpriteLocust(){
    int spriteWidth = 64;
    int spriteHeight = 64;
    int upY = 64;
    int downY = 0;
    int rightY = 128;
    for (int i = 0; i < getSpriteLength(); i++) {
      int x = i%getSpriteLength() * spriteWidth;
      enemySprites[i] = enemySprite.get(x, rightY, spriteWidth, spriteHeight);
      enemySpritesUP[i] = enemySprite.get(x, upY, spriteWidth, spriteHeight);
      enemySpritesDOWN[i] = enemySprite.get(x, downY, spriteWidth, spriteHeight);
    }
  }



}
