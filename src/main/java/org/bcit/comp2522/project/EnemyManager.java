package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Class that creates all manages all the enemies.
 *
 * @author Victor Vasconcellos
 * @version 2023
 */
public abstract class EnemyManager extends Enemy {

  private ArrayList<Enemy> enemies;

  int numEnemies;

  public EnemyManager(float xpos, float ypos, Window window, int health, int speed) {
    super(xpos, ypos, window, health, speed);
  }

}
