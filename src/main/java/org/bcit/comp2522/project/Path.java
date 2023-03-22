package org.bcit.comp2522.project;

public class Path {
  private Node head;
  private Node tail;
  private Window window;
  public Path(Window window) {
    this.window = window;
    head = new Node(0, 180);
    tail = new Node(640, 180);
    Node n1 = new Node(50, 180);
    head.next = n1;
    Node n2 = new Node(50, 130);
    n1.next = n2;
    Node n3 = new Node(100, 130);
    n2.next = n3;
    Node n4 = new Node(150, 130);
    n3.next = n4;
    Node n5 = new Node(150, 180);
    n4.next = n5;
    n5.next = tail;
  }

  public void draw() {
    Node current = head;
    while (current != null) {
      window.pushStyle();
      window.fill(0, 255, 0);
      window.square(current.getXpos(), current.getYpos(), 20);
      window.popStyle();
      current = current.next;
    }
  }

  public Node getHead() {
    return head;
  }
}
