package org.bcit.comp2522.project;

public class Player {
private static Player player;

  int currentLevel;
  int currentScore;
  int coins;
  int health;


  private Player(){
    currentLevel = 0;
    currentScore = 1000;
    coins = 100;
    health = 10;
  };

  public static Player getInstance(){
    if(player == null) {
      player = new Player();

    }
    return player;

  }

  public static void resetStats(){

    int coins = 0;
    int health = 10;
  }



}
