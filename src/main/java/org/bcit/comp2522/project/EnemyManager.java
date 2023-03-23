package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * Class that manages all the enemies in the game.
 * It contains an ArrayList of enemies and methods to set up and initialize them.
 */
public class EnemyManager {
  private ArrayList<Enemy> enemies;

  int numEnemies;

  /**
   * Constructs an EnemyManager object with a Window object.
   *
   * @param window the Window object to associate with the EnemyManager
   */
  public EnemyManager(Window window) {

  }

  /**
   * Sets up the EnemyManager by initializing the enemies.
   * This method should be called after creating a new instance of the class.
   */
  public void setup() {
    this.init();
  }

  /**
   * Initializes the ArrayList of enemies.
   * This method is called by the setup() method.
   */
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
