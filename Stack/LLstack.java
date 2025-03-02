class Stack {
  private static class Node {
      int data;
      Node next;

      Node(int data) {
          this.data = data;
      }
  }

  private Node head; // Points to Top

  public void display() {
      Node cur = head;
      while (cur != null) {
          System.out.print(cur.data + " ");
          cur = cur.next;
      }
      System.out.println();
  }

  public void push(int value) {
      Node item = new Node(value);
      item.next = head;
      head = item;
  }

  public int pop() {
      if (isEmpty()) {
          throw new IllegalStateException("Stack is empty");
      }
      int element = head.data;
      head = head.next;
      return element;
  }

  public int peek() {
      if (isEmpty()) {
          throw new IllegalStateException("Stack is empty");
      }
      return head.data;
  }

  public boolean isEmpty() {
      return head == null;
  }

  public static void main(String[] args) {
      Stack stk = new Stack();
      stk.push(10);
      stk.push(20);
      stk.push(30);

      stk.display(); // 30 20 10
      System.out.println(stk.peek()); // 30

      while (!stk.isEmpty()) {
          System.out.print(stk.pop() + " ");
      }
      // Output: 30 20 10
  }
}