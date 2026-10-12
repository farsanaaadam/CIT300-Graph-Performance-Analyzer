import java.util.ArrayList;
import java.util.List;

public class PerformanceAnalyzer {
    private List<String> results = new ArrayList<>();

    public void addResult(String line) {
        results.add(line);
    }

    // Compare Linear vs Binary on a big sorted array (worst case: last element)
    public void compareSearch(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i * 2;   // sorted
        int key = arr[n - 1];

        long t1 = System.nanoTime();
        int[] linear = SearchOperations.linearSearch(arr, key);
        long linearTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        int[] binary = SearchOperations.binarySearch(arr, key);
        long binaryTime = System.nanoTime() - t2;

        printHeader();
        printRow("Search", "Linear Search", linear[1], linearTime);
        printRow("Search", "Binary Search", binary[1], binaryTime);
        System.out.println("=============================================");
        System.out.println("(Array size = " + n + ", worst case search)");

        addResult("Search | Linear Search | n=" + n + " | steps=" + linear[1] + " | time=" + linearTime + " ns");
        addResult("Search | Binary Search | n=" + n + " | steps=" + binary[1] + " | time=" + binaryTime + " ns");
    }

    // Compare BFS vs DFS on the graph
    public void compareGraph(Graph graph, int start) {
        long t1 = System.nanoTime();
        int bfsSteps = graph.bfs(start);
        long bfsTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        int dfsSteps = graph.dfs(start);
        long dfsTime = System.nanoTime() - t2;

        printHeader();
        printRow("Graph Traversal", "BFS", bfsSteps, bfsTime);
        printRow("Graph Traversal", "DFS", dfsSteps, dfsTime);
        System.out.println("=============================================");

        addResult("Graph Traversal | BFS | start=" + start + " | steps=" + bfsSteps + " | time=" + bfsTime + " ns");
        addResult("Graph Traversal | DFS | start=" + start + " | steps=" + dfsSteps + " | time=" + dfsTime + " ns");
    }

    public void displayAllResults() {
        System.out.println("=============================================");
        System.out.println("ALL RESULTS");
        System.out.println("=============================================");
        if (results.isEmpty()) {
            System.out.println("No results yet. Run some searches or comparisons first.");
            return;
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }
    }

    private void printHeader() {
        System.out.println("=============================================");
        System.out.println("PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-17s %-15s %-8s %-12s%n", "Operation", "Algorithm", "Steps", "Time(ns)");
    }

    private void printRow(String op, String algo, int steps, long time) {
        System.out.printf("%-17s %-15s %-8d %-12d%n", op, algo, steps, time);
    }
}