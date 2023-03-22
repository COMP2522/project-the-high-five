package org.bcit.comp2522.project;

public class Node {
  private float xpos;
  private float ypos;
  Node next;

  public Node(float xpos, float ypos) {
    this.xpos = xpos;
    this.ypos = ypos;
    next = null;
  }

  public float getXpos() {
    return xpos;
  }
  public float getYpos() {
    return ypos;
  }
}
