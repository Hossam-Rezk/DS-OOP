import java.util.Stack;

class Q2Stack {
    private int size;
    private int top;
    private int[] array;

    public StackCustom(int size) {
        this.size = size;
        this.top = -1;
        this.array = new int[size];
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        array[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

// Queue with O(1) Enqueue and O(n) Dequeue
class QueueEnqueueFast {
    private int size;
    private int addedElements = 0;
    private StackCustom s1;
    private StackCustom s2;

    public QueueEnqueueFast(int size) {
        this.size = size;
        this.s1 = new StackCustom(size);
        this.s2 = new StackCustom(size);
    }

    private void move(StackCustom from, StackCustom to) { // O(n)
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    public void enqueue(int value) { // O(1)
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        s1.push(value);
        addedElements++;
    }

    public int dequeue() { // O(n)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (s2.isEmpty()) { // Move elements only when s2 is empty
            move(s1, s2);
        }
        addedElements--;
        return s2.pop();
    }

    public boolean isEmpty() {
        return addedElements == 0;
    }

    public boolean isFull() {
        return addedElements == size;
    }
}

// Queue with O(n) Enqueue and O(1) Dequeue
class QueueDequeueFast {
    private int size;
    private int addedElements = 0;
    private StackCustom s1;
    private StackCustom s2;

    public QueueDequeueFast(int size) {
        this.size = size;
        this.s1 = new StackCustom(size);
        this.s2 = new StackCustom(size);
    }

    private void move(StackCustom from, StackCustom to) { // O(n)
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    public void enqueue(int value) { // O(n)
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        move(s1, s2);
        s1.push(value);
        move(s2, s1);
        addedElements++;
    }

    public int dequeue() { // O(1)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        addedElements--;
        return s1.pop();
    }

    public boolean isEmpty() {
        return addedElements == 0;
    }

    public boolean isFull() {
        return addedElements == size;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Queue with O(1) Enqueue and O(n) Dequeue:");
        QueueEnqueueFast qu1 = new QueueEnqueueFast(6);

        for (int i = 1; i <= 3; i++) {
            qu1.enqueue(i);
        }

        System.out.print(qu1.dequeue() + " "); // 1

        for (int i = 4; i <= 5; i++) {
            qu1.enqueue(i);
        }

        while (!qu1.isEmpty()) {
            System.out.print(qu1.dequeue() + " ");
        }
        System.out.println();

        System.out.println("\nQueue with O(n) Enqueue and O(1) Dequeue:");
        QueueDequeueFast qu2 = new QueueDequeueFast(6);

        for (int i = 1; i <= 3; i++) {
            qu2.enqueue(i);
        }

        System.out.print(qu2.dequeue() + " "); // 1

        for (int i = 4; i <= 5; i++) {
            qu2.enqueue(i);
        }

        while (!qu2.isEmpty()) {
            System.out.print(qu2.dequeue() + " ");
        }
        System.out.println();
    }
}
