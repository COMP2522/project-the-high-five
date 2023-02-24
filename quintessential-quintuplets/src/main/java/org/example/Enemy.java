package org.example;

import processing.core.PVector;
import java.awt.*;

public class Enemy extends Sprite{
    public Enemy (Color color, int size, PVector position, int health, int speed){
        super(color, size, position, health, speed);
    }
}
