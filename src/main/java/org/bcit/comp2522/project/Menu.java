package org.bcit.comp2522.project;

import processing.core.PImage;


/**
 * Displays a menu screen with three buttons for starting a new game, loading a saved game and viewing high scores.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Menu {

    private Window window;
    private PImage backgroundImage;

    private ButtonHandler startBH;

    private ButtonHandler loadBH;

    private ButtonHandler highscoreBH;

    private final int startButtonHeight = Window.windowHeight * 3 / 12;
    private final int loadButtonHeight = Window.windowHeight * 5 / 12;

    private final int hsButtonHeight = Window.windowHeight * 7 / 12;

    /**
     * Constructor for the Menu class. Loads the background image for the menu screen.
     *
     * @param window the Window that the menu is displayed on.
     */
    public Menu(Window window) {
        this.window = window;
        String dataPath = window.sketchPath("images");
        this.backgroundImage = window.loadImage(dataPath + "/laptop.jpg");

    }

    /**
     * Displays the menu screen with buttons for starting a new game, loading a saved game or viewing high scores.
     */
    public void display() {

        window.image(backgroundImage, 0, 0, Window.windowWidth, Window.windowHeight);

        int horizontalPos = Window.windowWidth/ 2;

        Button startButton = new Button(window, "START GAME",
                ButtonFunction.START, horizontalPos, startButtonHeight);
        Button loadButton = new Button(window, "LOAD GAME",
                ButtonFunction.LOAD, horizontalPos, loadButtonHeight);
        Button hsButton = new Button(window, "HIGH SCORES",
                ButtonFunction.HIGHSCORE, horizontalPos, hsButtonHeight);
        startBH = new ButtonHandler(startButton);
        loadBH = new ButtonHandler(loadButton);
        highscoreBH = new ButtonHandler(hsButton);

        startButton.displayButton();
        loadButton.displayButton();
        hsButton.displayButton();

    }

    /**
     * Handles mouse clicks on the buttons in the menu screen.
     *
     * @param mouseX the x-coodinate of the mouse click.
     * @param mouseY the y-coorindate of the mouse click.
     */
    public void mousePressed(int mouseX, int mouseY) {
        startBH.clickHandler(mouseX, mouseY);
        loadBH.clickHandler(mouseX, mouseY);

        highscoreBH.clickHandler(mouseX, mouseY);
    }

}
