package org.bcit.comp2522.project;

public class Bee extends Enemy{
  public Bee(int x, int y, Window window, int health, int speed, int damage, int reward, Level level) {
      super(x, y, window, health, speed, damage, reward, level);
      enemySprite = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/firewasp.png");
      loadSpriteBee();
      setSize(80);
  }

  private void loadSpriteBee(){
    int spriteWidth = 96;
    int spriteHeight = 96;
    int upY = 96;
    int downY = 0;
    int rightY = 192;
    for (int i = 0; i < getSpriteLength(); i++) {
      int x = i%getSpriteLength() * spriteWidth;
      enemySprites[i] = enemySprite.get(x, rightY, spriteWidth, spriteHeight);
      enemySpritesUP[i] = enemySprite.get(x, upY, spriteWidth, spriteHeight);
      enemySpritesDOWN[i] = enemySprite.get(x, downY, spriteWidth, spriteHeight);
    }
  }

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
