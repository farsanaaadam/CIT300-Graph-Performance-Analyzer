import java.util.Arrays;

public class ArrayOperations {
    private int[] data;
    private int size;

    public ArrayOperations(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // Insert at end - O(1)
    public boolean insert(int value) {
        if (size == data.length) {
            System.out.println("Array is full! Cannot insert.");
            return false;
        }
        data[size++] = value;
        System.out.println(value + " inserted.");
        return true;
    }
}
// Simple linear search - returns index or -1
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    // Delete first occurrence of value - O(n)
    public boolean delete(int value) {
        if (size == 0) {
            System.out.println("Array is empty! Nothing to delete.");
            return false;
        }
        int index = search(value);
        if (index == -1) {
            System.out.println(value + " not found.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];   // shift left
        }
        size--;
        System.out.println(value + " deleted.");
        return true;
    }
