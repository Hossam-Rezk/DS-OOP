import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destroy value: " + data + " at address " + this);
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;
    
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void insertEnd(int value) {
        Node item = new Node(value);
        addNode(item);
        if (head == null) {
            head = tail = item;
        } else {
            tail.next = item;
            tail = item;
        }
    }

    public void insertFront(int value) {
        Node item = new Node(value);
        addNode(item);
        if (head == null) {
            head = tail = item;
        } else {
            item.next = head;
            head = item;
        }
    }
    public Node getNth(int n) { // O(n) time - O(1) memory
      int cnt = 0;
      Node cur = head;
      while (cur != null) {
          if (++cnt == n)
              return cur;
          cur = cur.next;
      }
      return null; // still more steps needed - NOT found
  }

  public Node getNthBack(int n) { // O(n) time - O(1) memory
      if (length < n)
          return null;
      return getNth(length - n + 1); // give it its 1-based index forward
  }
}
