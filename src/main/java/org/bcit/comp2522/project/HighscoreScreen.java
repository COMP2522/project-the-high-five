package org.bcit.comp2522.project;

import java.util.ArrayList;

public class HighscoreScreen {

    private Window window;

    String input = "";

    public HighscoreScreen(Window window) {
        this.window = window;
    }

    public void display() {

        window.background(255);
        window.fill(0);
        //window.text("Enter some text:", Window.windowWidth / 2, Window.windowHeight / 2 - 20);
        //window.text(input, Window.windowWidth / 2, Window.windowHeight / 2 + 20);
    }

//    public void displayHighscores() {
//        Highscore hs = new Highscore();
//        ArrayList<Highscore> highscores = new ArrayList<Highscore>();
//        highscores = hs.retrieveHighscores();
//        for (int i = 0; i < highscores.size(); i++){
//
//
//            window.text(highscores., Window.windowWidth / 2, Window.windowHeight / 2 - 20);
//
//        }
//
//    }
}
