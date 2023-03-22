package org.bcit.comp2522.project;

/**
 * Bullet.java
 * Represents the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class Bullet extends Sprite {

    public Bullet(float xpos, float ypos, Window window) {
        super(xpos, ypos, window);
    }

    public void draw() {
        window.fill(255, 0, 0);
        window.ellipse(20, 20, 10, 10);
    }

}
