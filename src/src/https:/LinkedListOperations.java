public class LinkedListOperations {

    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    // Insert at front - O(1)
    public void insertAtFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println(value + " inserted at front.");
    }
}
