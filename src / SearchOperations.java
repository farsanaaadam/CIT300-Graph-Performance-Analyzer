public class SearchOperations {

    // Linear Search - O(n). Returns {index, steps}
    public static int[] linearSearch(int[] arr, int key) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) return new int[]{i, steps};
        }
        return new int[]{-1, steps};
    }
}
// Binary Search - O(log n). Array MUST be sorted. Returns {index, steps}
    public static int[] binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1, steps = 0;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) return new int[]{mid, steps};
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return new int[]{-1, steps};
    }
