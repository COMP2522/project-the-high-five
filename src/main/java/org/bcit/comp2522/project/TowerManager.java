package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * This class manages the tower class and its methods.
 * This class makes it easy to organize and recognize everywhere a tower is used in the game.
 * @author gursidhsandhu
 * @version 1.0
 */
public class TowerManager {

  private final ArrayList<org.bcit.comp2522.project.Tower> towers;
  private Window window;

  /**
   * A TowerManager object is an array of towers.
   * @param window represents the window where game is played.
   */
  public TowerManager (Window window){
    this.window = window;
    towers = new ArrayList<>();
  }

  /**
   * This method adds a tower to the list of towers.
   * @param tower represents a single tower.
   */
  public void add(org.bcit.comp2522.project.Tower tower){
    towers.add(tower);
  }


  /**
   * Method that draws out each tower currently in the array.
   */
  public void draw(){
    for(org.bcit.comp2522.project.Tower tower : towers){

      tower.draw();
    }
  }

  /**
   * Method that calls the shoot method in tower.
   * @param enemyManager represents an enemyManager object that holds an array of enemies.
   */
  public void shoot(EnemyManager enemyManager){
    for(org.bcit.comp2522.project.Tower tower: towers){
      tower.shootingEnemy(enemyManager);
    }
  }

  /**
   * Method that calls the inRange method in tower.
   */
  public void inRange(){
    for(org.bcit.comp2522.project.Tower tower : towers){
      if(tower.isInRange()){
        window.stroke(255,0,0);
      } else{
        window.stroke(0,0,0);
      }
    }
  }

}
