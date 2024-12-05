package org.bcit.comp2522.project;

import java.util.ArrayList;
import processing.core.PImage;

/**
 * This class represents the path on the map that the enemy can travel on.
 *
 * @author quintessential quintuplets
 * @version 1.0
 */
public class Path {
  private Node head;
  private Node tail;
  private Window window;
  private final PImage image;

  private ArrayList<Node> corners = new ArrayList<Node>();

  /**
   * Creates a path for the enemies to follow.
   *
   * @param window the window that the path will be drawn on
   */
  public Path(Window window) {
    this.window = window;
    image = window.loadImage("src/main/java/org/bcit/comp2522/project/asset/sand_tile.png");

  }

  /**
   * Draws the path.
   */
  public void draw() {
    Node current = head;
    while (current != null) {
      window.pushStyle();
      window.image(image, current.getXpos(), current.getYpos(), 48, 48);
      window.popStyle();
      current = current.next;
    }
  }

  /**
   * Adds a corner to the path.
   *
   * @param x x position of the corner
   * @param y y position of the corner
   * @return if the corner was added
   */
  public boolean addCorner(int x, int y) {
    boolean result = false;
    Node temp = new Node(x, y);
    if (corners.size() == 0) {
      corners.add(temp);
      head = temp;
      result = true;
    } else {
      if (corners.get(corners.size() - 1).getXpos() == temp.getXpos()
              || corners.get(corners.size() - 1).getYpos() == temp.getYpos()) {
        corners.add(temp);
        result = true;
      } else {
        result = false;
      }
    }
    return result;
  }

  /**
   * Prints the nodes in the path. For testing purposes.
   */
  public void printNode() {
    Node current = head;
    while (current != null) {
      System.out.println("Current node:" + current.getXpos() + " " + current.getYpos());
      current = current.next;
    }
  }

  /**
   * Checks if a node already exist.
   *
   * @param x x position of the node
   * @param y y position of the node
   * @return if the node already exist
   */
  public boolean nodeExist(int x, int y) {
    boolean result = false;
    Node current = head;
    while (current != null) {
      if (current.getXpos() == x && current.getYpos() == y) {
        result = true;
        break;
      }
      current = current.next;
    }
    return result;
  }

  /**
   * Connects the corners of the path.
   *
   * @return if the corners were connected
   */
  public boolean connectCorners() {
    boolean result = false;
    //int count = 0;
    if (corners.size() > 1) {
      for (int i = 0; i < corners.size() - 1; i++) {
        Node current = corners.get(i);
        Node next = corners.get(i + 1);
        if (current.getXpos() == next.getXpos()) {
          if (current.getYpos() < next.getYpos()) {
            for (int j = current.getYpos() + 48; j < next.getYpos(); j += 48) {
              if (!nodeExist(current.getXpos(), j)) {
                Node temp = new Node(current.getXpos(), j);
                current.next = temp;
                current = temp;
                //System.out.println("Node added:" + current.getXpos() + " " + current.getYpos());
              } else {
                //System.out.println("Node already exist");
              }

            }
          } else {
            for (int j = current.getYpos() - 48; j > next.getYpos(); j -= 48) {
              if (!nodeExist(current.getXpos(), j)) {
                Node temp = new Node(current.getXpos(), j);
                current.next = temp;
                current = temp;
                //System.out.println("Node added:" + current.getXpos() + " " + current.getYpos());
              } else {
                //System.out.println("Node already exist");
              }
            }
          }
        } else {
          if (current.getXpos() < next.getXpos()) {
            for (int j = current.getXpos() + 48; j < next.getXpos(); j += 48) {
              if (!nodeExist(j, current.getYpos())) {
                Node temp = new Node(j, current.getYpos());
                current.next = temp;
                current = temp;
                //System.out.println("Node added:" + current.getXpos() + " " + current.getYpos());
              } else {
                //System.out.println("Node already exist");
              }

            }
          } else {
            for (int j = current.getXpos() - 48; j > next.getXpos(); j -= 48) {
              if (!nodeExist(j, current.getYpos())) {
                Node temp = new Node(j, current.getYpos());
                current.next = temp;
                current = temp;
                //System.out.println("Node added:" + current.getXpos() + " " + current.getYpos());
              } else {
                //.out.println("Node already exist");
              }

            }
          }
        }
        current.next = next;
      }
      result = true;
    }
    return result;
  }

  // this is for other issue im working on for later
  // this method checks if a certain tower is on the path or not
  // this method is used in window and all parameters are based off one specific tower
  // checks that one tower with every single node in the linked list
  //public boolean isTowerOnPath(float x, float y, float radius) {
  // Node current = head;
  // while (current != null) {
  // if (Math.sqrt(Math.pow(x - current.getXpos(), 2)
  // + Math.pow(y - current.getYpos(), 2)) <= radius) {
  // return true if the tower is found to be on a node
  //  return true;
  //}
  // current = current.next;
  //}
  // return false if the tower is not on any node in the path
  // return false;
  //}

  /**
   * Gets the head of the path.
   *
   * @return the head of the path
   */
  public Node getHead() {
    return head;
  }

  /**
   * Resets the path.
   */
  public void reset() {
    head = null;
    tail = null;
    corners.clear();
  }

  /**
   * Clears the corners of the path.
   */
  public void clearCorner() {
    corners.clear();
  }
}
