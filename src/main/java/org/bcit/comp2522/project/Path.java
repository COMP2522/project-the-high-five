package org.bcit.comp2522.project;

import processing.core.PImage;

import java.util.ArrayList;

public class Path {
  private Node head;
  private Node tail;
  private Window window;
  private final PImage image;

  private ArrayList<Node> corners = new ArrayList<Node>();

  /**
   * Creates a path for the enemies to follow.
   * @param window
   */
  public Path(Window window) {
    this.window = window;
    image = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/d5372s0-96ad72be-b30e-44ad-b239-81feb2bfc32d.jpg");

  }

  public void draw() {
    Node current = head;
    while (current != null) {
      window.pushStyle();
//      window.fill(0, 255, 0);
//      window.square(current.getXpos(), current.getYpos(), 20);
      window.image(image, current.getXpos(), current.getYpos(), 48, 48);
      window.popStyle();
      current = current.next;
    }
  }

  /**
   * Adds a corner to the path.
   * @param x x position of the corner
   * @param y y position of the corner
   * @return if the corner was added
   */
  public boolean addCorner(int x, int y){
    boolean result = false;
//    if (x % 48 != 0 || y % 48 != 0){
//      return false;
//    }
    Node temp = new Node(x, y);
    if (corners.size() == 0){
      corners.add(temp);
      head = temp;
      result = true;
    } else {
      if (corners.get(corners.size() - 1).getXpos() == temp.getXpos() || corners.get(corners.size() - 1).getYpos() == temp.getYpos()){
        corners.add(temp);
        result = true;
      } else {
        result = false;
      }
    }
    return result;
  }

  /**
   * Connects the corners of the path.
   * @return if the corners were connected
   */
  public boolean connectCorners(){
    boolean result = false;
    //int count = 0;
    if (corners.size() > 1){
      for (int i = 0; i < corners.size() - 1; i++){
        Node current = corners.get(i);
        Node next = corners.get(i + 1);
        if (current.getXpos() == next.getXpos()){
          if (current.getYpos() < next.getYpos()){
            for (int j = current.getYpos() + 48; j < next.getYpos(); j += 48){
              Node temp = new Node(current.getXpos(), j);
              current.next = temp;
              current = temp;
            }
          } else {
            for (int j = current.getYpos() - 48; j > next.getYpos(); j -= 48){
              Node temp = new Node(current.getXpos(), j);
              current.next = temp;
              current = temp;
            }
          }
        } else {
          if (current.getXpos() < next.getXpos()){
            for (int j = current.getXpos() + 48; j < next.getXpos(); j += 48){
              Node temp = new Node(j, current.getYpos());
              current.next = temp;
              current = temp;
            }
          } else {
            for (int j = current.getXpos() - 48; j > next.getXpos(); j -= 48){
              Node temp = new Node(j, current.getYpos());
              current.next = temp;
              current = temp;
            }
          }
        }
        current.next = next;
      }
      result = true;
    }
    return result;
  }

  // this is for other issue im working on
  // this method checks if a certain tower is on the path or not
  // this method is used in window and all parameters are based off one specific tower
  // checks that one tower with every single node in the linked list
  //public boolean isTowerOnPath(float x, float y, float radius) {
   // Node current = head;
   // while (current != null) {
     // if (Math.sqrt(Math.pow(x - current.getXpos(), 2) + Math.pow(y - current.getYpos(), 2)) <= radius) {
        // return true if the tower is found to be on a node
      //  return true;
      //}
     // current = current.next;
    //}
    // return false if the tower is not on any node in the path
   // return false;
  //}


  public Node getHead() {
    return head;
  }

  public void reset() {
    head = null;
    tail = null;
    corners.clear();
  }

  public void clearCorner(){
    corners.clear();
  }
}
