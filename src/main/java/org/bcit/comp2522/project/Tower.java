package org.bcit.comp2522.project;


/**
 * This class represents the towers in the game
 * Contains attributes and methods each tower
 * object should have
 * @author gursidhsandhu
 */
public class Tower extends Sprite implements Collidable{

  private int attackRate;
  private int range;

  // this ensures every tower is same size
  private final int baseSize = 40;

  public Tower(float xpos, float ypos,Window window) {
    super(xpos, ypos, window);
  }

  public void shoot(){}

  // drawing criteria for towers
  public void draw(){

    window.pushStyle();
    // draw the base square of the tower
    window.fill(100, 100, 100);
    window.stroke(0, 0, 0);
    window.strokeWeight(2);
    window.square(getXpos(), getYpos(), baseSize);

    // draw the top of the tower
    window.fill(211, 211, 211);
    window.stroke(0, 0, 0);
    window.strokeWeight(2);
    window.rect(getXpos() + baseSize / 4, (float) (getYpos() - baseSize*1.5), (baseSize/2), (float) (baseSize*1.5));

    // draw the top triangle of the tower
    window.fill(255,0,0);
    window.stroke(0,0,0);
    window.strokeWeight(2);
    window.triangle(getXpos() + baseSize/4, (float) (getYpos() - baseSize*1.5), getXpos() + baseSize/2 , (float) (getYpos() - (baseSize*1.5) - (baseSize/2))
        ,getXpos() + baseSize - (baseSize/4),(float) (getYpos() - baseSize*1.5));

    window.popStyle();
  }


  @Override
  public boolean collide(Collidable other) {
    return false;
  }
}
