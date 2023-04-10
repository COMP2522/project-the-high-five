package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BulletManagerTest {

  private static String[] appletArgs = new String[]{"towerDefence"};
  private static Window window;

  @BeforeAll
  static void setup() {
    window = new Window();
    PApplet.runSketch(appletArgs, window);
  }

  @Test
  void bulletManagerObjectIsCreated() {
    BulletManager bulletManager = new BulletManager(window);
    assertTrue(bulletManager.bullets.isEmpty());
  }

  @Test
  void addBulletTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(0, 0, window, 0);
    bulletManager.addBullet(bullet);
    assertEquals(1, bulletManager.bullets.size());
  }

  @Test
  void addBulletTest2() {
    BulletManager bulletManager = new BulletManager(window);
    for (int i = 0; i < 10; i++) {
      Bullet bullet = new Bullet(i * 10, i * 10, window, i);
      bulletManager.addBullet(bullet);
    }
    assertEquals(10, bulletManager.bullets.size());
  }

  @Test
  void addBulletTest3() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet1 = new Bullet(0, 0, window, 0);
    Bullet bullet2 = new Bullet(10, 10, window, 0);
    Bullet bullet3 = new Bullet(640, 360, window, 0);
    bulletManager.addBullet(bullet1);
    bulletManager.addBullet(bullet2);
    bulletManager.addBullet(bullet3);
    assertEquals(3, bulletManager.bullets.size());
  }

  @Test
  void addMultipleBulletsTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet1 = new Bullet(0, 0, window, 0);
    Bullet bullet2 = new Bullet(10, 10, window, 0);
    Bullet bullet3 = new Bullet(20, 20, window, 0);
    bulletManager.addBullet(bullet1);
    bulletManager.addBullet(bullet2);
    bulletManager.addBullet(bullet3);
    assertEquals(3, bulletManager.bullets.size());
  }

  @Test
  void addBulletAndCheckContentsTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(0, 0, window, 0);
    bulletManager.addBullet(bullet);
    assertTrue(bulletManager.bullets.contains(bullet));
  }

  @Test
  void addBulletWithNonZeroPositionTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(100, 100, window, 0);
    bulletManager.addBullet(bullet);
    assertEquals(1, bulletManager.bullets.size());
    assertEquals(100, bullet.getXpos());
    assertEquals(100, bullet.getYpos());
  }

  @Test
  void addBulletWithoutAffectingOthersTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet1 = new Bullet(0, 0, window, 0);
    Bullet bullet2 = new Bullet(10, 10, window, 0);
    bulletManager.addBullet(bullet1);
    bulletManager.addBullet(bullet2);
    assertEquals(2, bulletManager.bullets.size());
    assertTrue(bulletManager.bullets.contains(bullet1));
    assertTrue(bulletManager.bullets.contains(bullet2));
  }

  @Test
  void removeBulletTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(0, 0, window, 0);
    bulletManager.addBullet(bullet);
    assertEquals(1, bulletManager.bullets.size());

    bullet.setIsHit(true);
    bulletManager.removeBullet();
    assertEquals(0, bulletManager.bullets.size());
  }

  @Test
  void removeBulletFromMultipleBulletsTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet1 = new Bullet(0, 0, window, 0);
    Bullet bullet2 = new Bullet(10, 10, window, 0);
    bulletManager.addBullet(bullet1);
    bulletManager.addBullet(bullet2);
    assertEquals(2, bulletManager.bullets.size());

    bullet1.setIsHit(true);
    bulletManager.removeBullet();
    assertEquals(1, bulletManager.bullets.size());
    assertTrue(bulletManager.bullets.contains(bullet2));
  }

  @Test
  void removeBulletWithoutHitTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(0, 0, window, 0);
    bulletManager.addBullet(bullet);
    assertEquals(1, bulletManager.bullets.size());

    bullet.setIsHit(false);
    bulletManager.removeBullet();
    assertEquals(0, bulletManager.bullets.size());
  }

  @Test
  void removeMultipleBulletsTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet1 = new Bullet(0, 0, window, 0);
    Bullet bullet2 = new Bullet(10, 10, window, 0);
    bulletManager.addBullet(bullet1);
    bulletManager.addBullet(bullet2);
    assertEquals(2, bulletManager.bullets.size());

    bullet1.setIsHit(true);
    bullet2.setIsHit(true);
    bulletManager.removeBullet();
    bulletManager.removeBullet();
    assertEquals(0, bulletManager.bullets.size());
  }

  @Test
  void removeBulletBasedOnPositionTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(-10, 0, window, 0);
    bulletManager.addBullet(bullet);
    assertEquals(1, bulletManager.bullets.size());

    bulletManager.removeBullet();
    assertEquals(0, bulletManager.bullets.size());
  }

  @Test
  void removeBulletWithHitAndPositionTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet1 = new Bullet(0, 0, window, 0);
    Bullet bullet2 = new Bullet(-10, 0, window, 0);
    bulletManager.addBullet(bullet1);
    bulletManager.addBullet(bullet2);
    assertEquals(2, bulletManager.bullets.size());

    bullet1.setIsHit(true);
    bulletManager.removeBullet();
    bulletManager.removeBullet();
    assertEquals(0, bulletManager.bullets.size());
  }

  @Test
  void removeOutOfBoundsBulletTest() {
    BulletManager bulletManager = new BulletManager(window);
    Bullet bullet = new Bullet(window.width + 1, 0, window, 0);
    bulletManager.addBullet(bullet);
    assertEquals(1, bulletManager.bullets.size());

    bulletManager.removeBullet();
    assertEquals(0, bulletManager.bullets.size());
  }
}
