package org.bcit.comp2522.project;

/**
 * Grid class. Draws the grid on the screen. Only used for testing purposes.
 *
 * @author Quan Tran
 */
public class Grid {

  private Window window;

  /**
   * Constructs a Grid object.
   *
   * @param window the window that the grid is drawn on
   */
  public Grid(Window window) {
    this.window = window;
  }

  /**
   * Draws the grid on the screen.
   */
  public void draw() {
    window.pushStyle();
    window.stroke(204, 102, 0);
    window.line(40, 0, 40, 720);
    window.line(1240, 0, 1240, 720);
    window.popStyle();
    window.pushStyle();
    window.stroke(27, 168, 240);
    for (int i = 40; i <= 1240; i += 48) {
      window.line(i, 0, i, 720);
      window.textSize(20);
      window.text(i, i + 10, 700);
      window.fill(27, 168, 240);
    }
    for (int i = 0; i <= 720; i += 48) {
      window.line(40, i, 1240, i);
      //window.text(i, 10, i);
    }
    window.popStyle();
    window.pushStyle();

    for (int i = 0; i <= 720; i += 48) {
      window.textSize(20);
      window.text(i, 20, i + 10);
      window.fill(27, 168, 240);
    }
    window.fill(27, 168, 240);
    window.popStyle();
  }
}
