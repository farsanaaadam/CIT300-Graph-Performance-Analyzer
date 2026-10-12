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
// Insert at end - O(n)
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        System.out.println(value + " inserted at end.");
    }
// Delete by value - O(n)
    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty! Nothing to delete.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println(value + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println(value + " deleted.");
        }
    }
