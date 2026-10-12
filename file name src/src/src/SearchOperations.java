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
