package org.bcit.comp2522.project;

import  java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Window class that sets up and runs the game window, and contains instances of enemies,
 * bullets, and path objects.
 */
public class Window extends PApplet {

  /**
   * The width of the game window.
   */
  public static final int windowWidth = 1280;
  /**
   * The height of the game window.
   */
  public static final int windowHeight = 720;

  LevelManager levelManager;
  Level level_1;
  Level level_2;
  Level level_3;
  Level level_4;
  Level level_5;


  private String userInput;

  private static PImage background;


  private Menu menu;

  private HighscoreScreen highscoreScreen;
  private WinningScreen ws;

  private LosingScreen ls;

  private int stage;

  private ButtonHandler bh;
  private StateManager sm;

  Grid grid;

  public Window(){
    userInput = "";

  }




  public int getStage(){
    return stage;
  }

  public LevelManager getLevelManager(){
    return levelManager;
  }

  /**
   * Sets up the game window and initializes objects.
   */
  public void setup() {
    Player.getInstance();
    stage = 1;
    menu = new Menu(this);
    highscoreScreen = new HighscoreScreen(this);
    ws = new WinningScreen(this);
    ls = new LosingScreen(this);

    this.init();
  }

  /**
   * Setter for the stage variable.
   * @param stage represents what stage the game is in.
   */
  public void setStage(int stage) {
    this.stage = stage;
  }

  /**
   * Setter to set the value for userInput variable.
   * @param input represents what the user inputs to the game.
   */
  public void setUserInput(String input){
    this.userInput = input;
  }

  /**
   * Getter for the userInput variable.
   * @return the value that the user inputs.
   */
  public String getUserInput(){
    return userInput;
  }

  /**
   * Method that initializes the objects displayed on the window.
   */
  public void init() {
    background = this.loadImage("src/main/java/org/bcit/comp2522/project/asset/BackDrop.png");
    levelManager = new LevelManager(this, 5);
    sm = new StateManager(this, levelManager);
    level_1 = new Level_1(this);
    level_2 = new Level_2(this);
    level_3 = new Level_3(this);
    level_4 = new Level_4(this);
    level_5 = new Level_5(this);
    grid = new Grid(this);

    levelManager.addLevel(level_1);
    levelManager.addLevel(level_2);
    levelManager.addLevel(level_3);
    levelManager.addLevel(level_4);
    levelManager.addLevel(level_5);
    //enemyManager = new EnemyManager(this);
    // array of bullets
    //bullets = new ArrayList<>();

    //enemies = new ArrayList<>();
    //towers = new ArrayList<>();
  }

  private static final Object lock = new Object();

  /**
   * Draws objects on the game window.
   */
  public void draw() {

    new Thread(() -> {
      sm.push(FileManager.readFromFile());
    }).start();
    switch (stage) {
      case 1:
        menu.display();
        break;
      case 2:

        synchronized (lock) {
          levelManager.draw();

          new Thread(() -> {
          FileManager.writeToFile(new GameState(Player.getInstance(), this));
          FileManager.readAndLoadFromFile();
        }).start();

        }

        break;
      case 3:
        ls = new LosingScreen(this);
        ls.display();
        break;
      case 4:
        ws = new WinningScreen(this);
        ws.display();
        break;

      case 5:
        highscoreScreen.refreshHighscores();
        highscoreScreen.display();
        break;
    }
  }

  /**
   * Method that recognizes if the player has pressed the mouse.
   */
  public void mousePressed() {
    if (stage == 1) {
      menu.mousePressed(mouseX, mouseY);
    }
  }

  /**
   * Sets up the size of the game window.
   */
  public void settings() {
    size(windowWidth, windowHeight);
  }

  /**
   * Method that recognizes if the player has pressed a key on the keyboard.
   * Based on what key is pressed, a different action will take place.
   */
  public void keyPressed() {
    if (stage != 3 && stage != 4) {
      if (key == 'm' || key == 'M') {
        stage = 1;
        this.init();

      }

      if (key == 'z' || key == 'Z') {
        levelManager.nextLevel();
      }

    } else {
      if (userInput == null){
        userInput = "";
      }

      if (Character.isLetter(key)) {
        userInput += key;
        //System.out.println(userInput);
      } else {
        if (key == BACKSPACE && userInput.length() > 0){
          userInput = userInput.substring(0, userInput.length() - 1);
          //System.out.println(userInput);
        } else {
          if (key == ENTER) {
            ws.logHighscore();
          }
        }
      }
    }
  }
  /**
   * Main method that runs the game.
   *
   * @param passedArgs command line arguments
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"towerDefence"};
    Window tdGame = new Window();
    PApplet.runSketch(appletArgs, tdGame);
  }
}
