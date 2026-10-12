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
