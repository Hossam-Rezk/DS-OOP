class Deque { // Double-ended queue
    private int size;
    private int front = 0;
    private int rear = 0;
    private int addedElements = 0;
    private int[] array;

    public Deque(int size) {
        this.size = size;
        this.array = new int[size];
    }

    private int next(int pos) {
        return (pos + 1) % size;
    }

    private int prev(int pos) {
        return (pos - 1 + size) % size;
    }

    public void enqueueRear(int value) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        array[rear] = value;
        rear = next(rear);
        addedElements++;
    }

    public void enqueueFront(int value) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        front = prev(front);
        array[front] = value;
        addedElements++;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        int value = array[front];
        front = next(front);
        addedElements--;
        return value;
    }

    public int dequeueRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        rear = prev(rear);
        int value = array[rear];
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
        Deque dq = new Deque(6);

        dq.enqueueFront(3);
        dq.display();
        dq.enqueueFront(2);
        dq.enqueueRear(4);
        dq.enqueueFront(1);
        dq.enqueueFront(5);
        dq.enqueueFront(6);
        dq.display(); // 1 2 3 4

        System.out.println(dq.dequeueRear()); // 4
        dq.display(); // 1 2 3

        System.out.println(dq.dequeueFront()); // 1
        dq.display(); // 2 3

        System.out.println(dq.dequeueRear()); // 3
        System.out.println(dq.dequeueFront()); // 2

        while (!dq.isEmpty()) {
            dq.dequeueRear();
        }
        dq.display(); // Empty

        for (int i = 0; i < 6; ++i) {
            dq.enqueueRear(i + 10);
        }
        dq.display();
    }
}
