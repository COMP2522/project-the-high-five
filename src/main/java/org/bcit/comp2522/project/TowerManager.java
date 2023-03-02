package org.bcit.comp2522.project;

import java.util.ArrayList;

/**
 * This class manages the tower class
 * @author gursidhsandhu
 * @version 2023
 */
public abstract class TowerManager extends Tower {

  // list of tower objects
  private ArrayList<Tower> towers;

  int numbOfTowers;

  public TowerManager(float xpos, float ypos, Window window) {
    super(xpos, ypos, window);
  }
}
