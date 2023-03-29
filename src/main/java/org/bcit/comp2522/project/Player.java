package org.bcit.comp2522.project;

public class Player {
private static Player player;

  int currentLevel;
  int currentScore;
  int coins;


  private Player(){
    currentLevel = 0;
    currentScore = 0;
    coins = 0;
  };

  public static Player getInstance(){
    if(player == null) {
      player = new Player();

    }
    return player;

  }



}
