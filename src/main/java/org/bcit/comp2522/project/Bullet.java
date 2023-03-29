package org.bcit.comp2522.project;

/**
 * Bullet.java
 * Represents the bullets in the game.
 *
 * @author Aric Or
 * @version 1.0
 */
public class Bullet extends Sprite implements Movable, Collidable {

    public Bullet(float xpos, float ypos, Window window) {
        super(xpos, ypos, window);
    }

    public void draw() {
        window.fill(255, 0, 0);
        window.ellipse(getXpos(), getYpos(), 10, 10);
    }
    public int track(){
        int curr = 0;
        for(Enemy enemy:window.enemies){
           if (enemy.getXpos() > window.enemies.get(curr).getXpos()){
               curr = window.enemies.indexOf(enemy);
           }
        }
        return curr;
    }
    public void update(int tracking) {
        if (window.enemies.get(tracking).getXpos() != getXpos()){
            setXpos(getXpos() + 5);
        }
        if (window.enemies.get(tracking).getYpos() != getYpos()){
            setYpos(getYpos() + 5);
        }
        //setXpos(getXpos() + 5);
        //setYpos(getYpos() + 5);
    }
    public void move() {
        update(track());
    }


    @Override
    public boolean collide(Collidable other) {
        return false;
    }
}
