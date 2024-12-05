package org.bcit.comp2522.project;

import processing.core.PFont;

/**
 * Display buttons class for Menu options
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class Button {


    /**
     * Window object that the button belongs to.
     */
    private Window window;

    /**
     * The x-coordinate of the button's position within the Window.
     */
    private int x;

    /**
     * The y-coordinate of the button's position within the Window.
     */
    private int y;

    /**
     * The function of the button as defined byt the ButtonFunction enum.
     */
    ButtonFunction function; //enum function of a button

    /**
     * A boolean value indicating whether or not the mouse cursor is currently hovering over the button.
     */
    private boolean isHovered = false; //if the button is hovered over

    /**
     * The text displayed on the button.
     */
    private String text;



    private int buttonWidth;
    private int buttonHeight;

    private int buttonFontSize = 32;

    /**
     * Constructor for button.
     * @param window a Window object that the button will be added to
     * @param text  the text to display on the button
     * @param function a ButtonFunction object that represents the action to be performed
     * when the button is clicked
     * @param x  the x-coordinate of the button's position on the window
     * @param y  the y-coordinate of the button's position on the window
     */
    public Button(Window window, String text, ButtonFunction function, int x, int y){
        this.window = window;
        this.text = text;
        this.x = x;
        this.y = y;
        this.function = function;
    }

    /**
     * Returns the x-coordinate of a button's position.
     * @return  the x-coordinate of a button's position.
     */
    public int getX() {
        return x;
    }


    /**
     * Sets the x-coordinate of the button's position.
     * @param x - the x coordinate to set for the button's position.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of the button's position.
     * @return the y-coordinate of the button's position.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the button's position.
     * @param y - the y-coordinate to set for the button's position.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the text displayed on the button.
     * @return the test displayed on the button.
     */
    public String getText() {
        return text;
    }

    /**
     * sets the text to be displayed on the button.
     * @param text to be displayed on the buttons.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the width of the button.
     * @return the width of the button.
     */
    public int getWidth() {
        return buttonWidth;
    }

    /**
     * Sets the width of the button.
     * @param width - the width to set for the button.
     */
    public void setWidth(int width) {
        this.buttonWidth = width;
    }

    /**
     * Returns the height of the button.
     * @return the height of the button.
     */
    public int getHeight() {
        return buttonHeight;
    }

    /**
     * Sets the height of the button.
     * @param height - the height to set for the button.
     */
    public void setHeight(int height) {
        this.buttonHeight = height;
    }

    /**
     * Return whether the mouse is currently hovering the button.
     * @return true if the mouse is hovering over the button; false otherwise.
     */
    public boolean getHovered() {
        return isHovered;
    }

    /**
     * Returns the window that the button is currently in.
     * @return the window that the button is currently in.
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Returns the function associated with the button.
     * @return the function associated with the button.
     */
    public ButtonFunction getFunction() {
        return function;
    }

    /**
     * Sets whether the mouse is currently hovered over the button.
     * @param hovered - true if the mouse is currently hovering over the button;
     *                false otherwise.
     */
    public void setHovered(boolean hovered) {
        isHovered = hovered;
    }

    /**
     * Sets the shape of the button to a rectangle with a width of
     * 400 and a height of 100. The position of the rectangle is
     * centered at the button's x and y coordinates.
     */
    public void menuButtonShape(){
        int menuButtonWidth = 400;
        this.buttonWidth = menuButtonWidth;
        int menuButtonHeight = 100;
        this.buttonHeight = menuButtonHeight;
        window.rectMode(window.CENTER);
        window.fill(0,0,0);
        window.rect(this.x, this.y, buttonWidth,buttonHeight);
    }

    /**
     * Sets the font, color, and alignment for the text to be displayed on the button.
     * The text is centered at the button's x and y coordinates
     */
    public void menuButtonText(){
        PFont gameFont;
        String dataPath = window.sketchPath("fonts");
        gameFont = window.createFont("" + dataPath + "/Righteous-Regular.ttf", 400);
        window.textFont(gameFont);
        window.fill(255);
        window.textSize(buttonFontSize);
        window.textAlign(window.CENTER);
        window.text(this.text, this.x, this.y);
    }

    /**
     * Displays the button by calling both the menuButtonShapes() and menuButtonText() methods.
     */
    public void displayButton(){
        menuButtonShape();
        menuButtonText();
    }
}
