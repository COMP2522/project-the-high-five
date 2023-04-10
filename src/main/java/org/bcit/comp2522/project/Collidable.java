package org.bcit.comp2522.project;

/**
 * Interface that represents objects colliding together.
 * @author quintessential quintuplets
 * @version 1.0
 */
public interface Collidable {

    /**
     * Method that checks the collision between two objects.
     * @param other represents the incoming object.
     * @return true or false.
     */
    boolean collide(Object other);

    /**
     * Getter method for objects x position.
     * @return x position value.
     */
    float getXpos();

    /**
     * Getter method for the objects y position.
     * @return y position value.
     */
    float getYpos();
}
