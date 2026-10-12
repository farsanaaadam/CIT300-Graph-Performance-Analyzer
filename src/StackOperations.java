public class StackOperations {
    private int[] stack;
    private int top;

    public StackOperations(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == stack.length - 1; }

    // O(1)
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Stack is full.");
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed.");
    }
}

// O(1)
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }
        System.out.println(stack[top--] + " popped.");
    }

    // O(1)
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }
public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }
    }
