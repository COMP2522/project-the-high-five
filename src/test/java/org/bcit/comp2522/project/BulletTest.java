package org.bcit.comp2522.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {

  private static String[] appletArgs = new String[]{"towerDefence"};
  private static Window window;

  @BeforeAll
  static void setup() {
    window = new Window();
    PApplet.runSketch(appletArgs, window);
  }

  @Test
  void bulletObjectIsCreated() {
    Bullet bullet = new Bullet(0, 0, window, 0);
    assertNotNull(bullet);
  }

  @Test
  void bulletGetDamageTest() {
    Bullet bullet = new Bullet(0, 0, window, 0);
    assertEquals(1, bullet.getDamage());
  }

  @Test
  void bulletGetSizeTest() {
    Bullet bullet = new Bullet(0, 0, window, 0);
    assertEquals(10, bullet.getSize());
  }

  @Test
  void bulletHitTest() {
    Bullet bullet = new Bullet(0, 0, window, 0);
    assertFalse(bullet.getIsHit());
    bullet.setIsHit(true);
    assertTrue(bullet.getIsHit());
  }
}
