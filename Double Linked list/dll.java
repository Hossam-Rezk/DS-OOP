import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }

    void set(Node next, Node prev) {
        this.next = next;
        this.prev = prev;
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

    public void printReversed() {
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

    private void deleteNode(Node node) {
        length--;
        // Java handles garbage collection
    }

    private void addNode(Node node) {
        length++;
    }

    private void link(Node first, Node second) {
        if (first != null) {
            first.next = second;
        }
        if (second != null) {
            second.prev = first;
        }
    }

    public void insertEnd(int value) {
        Node item = new Node(value);
        addNode(item);

        if (head == null) {
            head = tail = item;
        } else {
            link(tail, item);
            tail = item;
        }
    }

    public void insertFront(int value) {
        Node item = new Node(value);
        addNode(item);

        if (head == null) {
            head = tail = item;
        } else {
            link(item, head);
            head = item;
        }
    }

    public void deleteNodeWithKey(int value) {
        if (length == 0) {
            System.out.println("Empty list!");
        } else if (head.data == value) {
            deleteFront();
        } else if (tail.data == value) {
            deleteEnd();
        } else {
            Node cur = head;
            while (cur != null) {
                if (cur.data == value) {
                    deleteAndLink(cur);
                    return;
                }
                cur = cur.next;
            }
            System.out.println("Value not found!");
        }
    }

    // positions NOT values
    public void deleteEvenPositions() {
        if (length <= 1)
            return;
        
        Node cur = head;
        while (cur != null && cur.next != null) {
            deleteAndLink(cur.next);
            cur = cur.next;
            if (cur == null)
                tail = cur;
        }
    }

    public boolean isPalindrome() {
      if (length <= 1)
          return true;

      int len = length / 2;
      Node start = head;
      Node end = tail;

      while (len-- > 0) {
          if (start.data != end.data)
              return false;
          start = start.next;
          end = end.prev;
      }
      return true;
  }

}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Add test cases or operations here
    }
}
