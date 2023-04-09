package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

/**
 * Displays Highscore screen and retrieves and displays highscores.
 * Provides methods to refresh and retrieve highscores from the database.
 * Uses Window class to display screen elements and load images.
 * Uses ArrayList of Highscore objects to store and retrieve highscores.
 */
public class HighscoreScreen {

    private Window window;

    private PImage backgroundImage;

    ArrayList<Highscore> highscores = new ArrayList<Highscore>();


    /**
     * Constructs a HighscoreScreen object with a Window object parameter.
     * @param window a Window object to display the screen elements and load images.
     */
    public HighscoreScreen(Window window) {
        this.window = window;
        this.backgroundImage = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/BackDrop.png");
    }

    /**
     * Displays the highscore screen and retrieves highscores from the database.
     */
    public void display() {

        window.image(backgroundImage, 0,0, Window.windowWidth, Window.windowHeight);
        window.textAlign(window.CENTER);
        window.fill(255);
        window.textSize(50);

        window.text("Leader Board", Window.windowWidth / 2 , Window.windowHeight * 2 / 12);
        window.textSize(40);
        retrieveHighscores();

    }

    /**
     * Refreshes highscores from the database. Populates the highscores ArrayList with the
     * retrieved highscores.
     */
    public void refreshHighscores(){
        Highscore hs = new Highscore();
        highscores = new ArrayList<Highscore>();
        highscores = hs.retrieveHighscores();

    }

    /**
     * Retrieves highscores from highscores ArrayList and displays them on the highscore screen. Displays user and
     * score with a specific format.
     */
    public void retrieveHighscores() {

        String user;
        int score;
        String entry;


        for (int i = 0; i < highscores.size(); i++){

            user = highscores.get(i).getUser().toUpperCase();
            score = highscores.get(i).getHighscore();

            window.text(user, Window.windowWidth * 2 / 6, (Window.windowHeight * (i + 3) / 12));
            window.text(score, Window.windowWidth * 4 /6, Window.windowHeight * (i + 3) / 12);

        }

    }

}
