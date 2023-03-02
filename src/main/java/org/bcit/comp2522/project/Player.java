package org.bcit.comp2522.project;

public class Player {

  int currentLevel;
  int towerNumber;
  int currentScore;
  int creepsKilled;

  public static Player player;
  private Player(){};

  public static Player getInstance(){
    if(player == null) {
      player = new Player();

    }
    return player;

  }


  public void placeTower(){
    //TODO write place tower
  }

}
