package org.bcit.comp2522.project;

import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

import processing.core.PVector;

/**
 * Class that creates all manages all the enemies.
 */
public class EnemyManager {
  private ArrayList<Enemy> enemies;

  int numEnemies;

  public EnemyManager(Window window) {

  }

  public void setup() {
    this.init();
  }

  public void init() {
    enemies = new ArrayList<Enemy>();
//    for (int i = 0; i < numEnemies; i++) {
//      enemies.add(new Enemy(
//                  new Color(208, 9, 9),
//                  Math.random(),
//                  new PVector(Math.random(0, this.width), Math.random(0, this.height)),
//                  Math.random(0, 2),
//                  Math.random(2, 10),
//                  this
//          ));
//    }

  }
}
