import java.util.Arrays;

class Queue {
    private int size;
    private int front = 0;
    private int rear = 0;
    private int addedElements = 0;
    private int[] array;

    public Queue(int size) {
        this.size = size;
        this.array = new int[size];
    }

    private int next(int pos) {
        return (pos + 1) % size;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        array[rear] = value;
        rear = next(rear);
        addedElements++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = array[front];
        front = next(front);
        addedElements--;
        return value;
    }

    public boolean isEmpty() {
        return addedElements == 0;
    }

    public boolean isFull() {
        return addedElements == size;
    }

    public void display() {
        System.out.print("Front " + front + " - Rear " + rear + "\t");
        if (isFull()) {
            System.out.println("Full");
        } else if (isEmpty()) {
            System.out.println("Empty\n");
            return;
        } else {
            System.out.println();
        }

        for (int cur = front, step = 0; step < addedElements; step++, cur = next(cur)) {
            System.out.print(array[cur] + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Queue qu = new Queue(6);
        assert qu.isEmpty();
        qu.display();

        for (int i = 1; i <= 6; ++i) {
            assert !qu.isFull();
            qu.enqueue(i);
            qu.display();
        }
        assert qu.isFull();

        for (int i = 1; i <= 6; ++i) {
            assert !qu.isEmpty();
            qu.dequeue();
            // qu.display();
        }

        for (int i = 1; i <= 6; ++i) {
            assert !qu.isFull();
            qu.enqueue(i);
            qu.display();
        }

        qu.dequeue();
        assert !qu.isFull();
        qu.enqueue(7);
        assert qu.isFull();
        qu.display();

        qu.dequeue();
        qu.dequeue();
        assert !qu.isFull();
        qu.enqueue(8);
        assert !qu.isFull();
        qu.display();
        qu.enqueue(9);
        assert qu.isFull();
        qu.display();

        for (int i = 1; i <= 6; ++i) {
            assert !qu.isEmpty();
            qu.dequeue();
            qu.display();
        }
    }
}

