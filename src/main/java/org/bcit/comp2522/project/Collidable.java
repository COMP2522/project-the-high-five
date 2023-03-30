package org.bcit.comp2522.project;

public interface Collidable {
    Enemy collide(Collidable other);

    float getXpos();

    float getYpos();
}
