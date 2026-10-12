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
