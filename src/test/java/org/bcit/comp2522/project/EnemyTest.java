package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private Window window;
    private Level level;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
//        PApplet applet = new PApplet();
//        PImage[] images = new PImage[10];
//        window = new Window(applet, images);
        window = new Window();
        level = new Level(window);
        enemy = new Enemy(50, 50, window, 100, 5, 5, 50, level);
    }

    @Test
    void testGetHealth() {
        assertEquals(100, enemy.getHealth());
    }

    @Test
    void testSetHealth() {
        enemy.setHealth(50);
        assertEquals(50, enemy.getHealth());
    }

    @Test
    void testGetIsDead() {
        assertFalse(enemy.getIsDead());
    }

//    @Test
//    void testOutOfBounds() {
//        enemy.setXpos(window.width + 10);
//        enemy.outOfBounds();
//        assertTrue(enemy.getIsDead());
//        assertEquals(50, level.getPlayer().getHealth());
//    }

    @Test
    void testLoadSprite() {
        enemy.loadSprite();
        assertNotNull(enemy.enemySprites[0]);
    }

    @Test
    void testDraw() {
        enemy.loadSprite();
        enemy.draw();
        // TODO: add visual tests for draw method
    }

//    @Test
//    void testCollideWithBullet() {
//        Bullet bullet = new Bullet(50, 50, window);
//        assertTrue(enemy.collide(bullet));
//        assertTrue(enemy.getIsDead());
//        assertEquals(60, level.getPlayer().getCoins());
//        Player.reset();
//    }

    @Test
    void testCollideWithNonBullet() {
        assertFalse(enemy.collide(new Object()));
    }

    @Test
    void testMove() {
        enemy.move();
        // TODO: add visual tests for move method
    }
}
