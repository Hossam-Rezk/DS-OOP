class Queue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.print("Queue: ");
        if (isEmpty()) {
            System.out.println("Empty\n");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Queue qu = new Queue();
        assert qu.isEmpty();
        qu.display();

        for (int i = 1; i <= 6; ++i) {
            qu.enqueue(i);
            qu.display();
        }

        for (int i = 1; i <= 6; ++i) {
            qu.dequeue();
            qu.display();
        }
    }
}
