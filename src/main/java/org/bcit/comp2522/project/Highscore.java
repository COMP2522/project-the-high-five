package org.bcit.comp2522.project;

public class Highscore {

    private int highscore;
    private String user;

    public Highscore(){


        this.highscore = Player.getInstance().currentScore;
    }


}


