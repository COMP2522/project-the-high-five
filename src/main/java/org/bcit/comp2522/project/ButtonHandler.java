package org.bcit.comp2522.project;

/**
 * This class handles interactions with menu items, including checking if a button is being hovered over and executing
 * appropriate actions when a button is clicked.
 *
 * @author Cheryl Lau
 * @version 1.0 2023
 */
public class ButtonHandler {

    private Window window;

    private Button button;


    /**
     * Constructor for ButtonHandler
     *
     * @param button the button that this handler will be associated with.
     */
    public ButtonHandler(Button button) {

        this.button = button;
        this.window = button.getWindow();
    }

    /**
     * Checks if the mouse is currently hovering over the button associated with this handler
     *
     * @param mouseX the current x-coordinate of the mouse
     * @param mouseY the current y-coorindate of the mouse
     * @return true if the mouse is currently hovering over the button, false otherwise.
     */
    public boolean checkHover(int mouseX, int mouseY) {
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();
        int xRadius = width / 2;
        int yRadius = height / 2;


        return mouseX >= x - xRadius && mouseX <= x + xRadius &&
                mouseY >= y - yRadius && mouseY <= y + yRadius;

    }


    /**
     * Handle a mouse click even on the button associated with this handler.
     *
     * @param mouseX the current x-coordinate of the mouse.
     * @param mouseY the current y-coorindate of the mouse.
     */
    public void clickHandler(int mouseX, int mouseY) {


        if (button.getFunction() == ButtonFunction.START && checkHover(mouseX, mouseY)) {

            //window.init();
            window.setStage(2);
            Player.resetStats();

        }
        if (button.getFunction() == ButtonFunction.HIGHSCORE && checkHover(mouseX, mouseY)) {
            window.setStage(5);
        }

        if (button.getFunction() == ButtonFunction.LOAD && checkHover(mouseX, mouseY)) {
            window.setStage(2);
            Thread myThread = new Thread(() -> {
                StateManager sm = new StateManager(window, window.getLevelManager());
                sm.mainPull(window.getLevelManager());
                sm.pull();
            });
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
            final int loadCoins = 75;
            Player.setCoins(loadCoins);
        }
    }
}
