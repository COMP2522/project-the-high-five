package org.bcit.comp2522.project;

/**
 * Node class. Used to create a linked list of path Coordinate.
 */
public class Node {
  private int xpos;
  private int ypos;
  Node next;
  /**
   * Constructs a Node object with the x and y position of the node.
   * @param xpos the x position of the node
   * @param ypos the y position of the node
   */
  public Node(int xpos, int ypos) {
    this.xpos = xpos;
    this.ypos = ypos;
    next = null;
  }
  /**
   * Returns the x position of the node.
   * @return the x position of the node
   */
  public int getXpos() {
    return xpos;
  }
  /**
   * Returns the y position of the node.
   * @return the y position of the node
   */
  public int getYpos() {
    return ypos;
  }
}
