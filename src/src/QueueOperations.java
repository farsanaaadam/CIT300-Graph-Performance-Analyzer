public class QueueOperations {
    private int[] queue;
    private int front, rear, count;

    public QueueOperations(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull()  { return count == queue.length; }

    // O(1) - circular queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        count++;
        System.out.println(value + " enqueued.");
    }
}
// O(1)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return;
        }
        System.out.println(queue[front] + " dequeued.");
        front = (front + 1) % queue.length;
        count--;
    }
public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }
