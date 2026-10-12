import java.util.*;

public class Graph {
    // Adjacency List representation
    private Map<Integer, List<Integer>> adj = new LinkedHashMap<>();

    public boolean hasVertex(int v) { return adj.containsKey(v); }
    public boolean isEmpty()        { return adj.isEmpty(); }

    public void addVertex(int v) {
        if (adj.containsKey(v)) {
            System.out.println("Vertex " + v + " already exists.");
            return;
        }
        adj.put(v, new ArrayList<>());
        System.out.println("Vertex " + v + " added.");
    }

    // Undirected edge
    public void addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) {
            System.out.println("Both vertices must exist first.");
            return;
        }
        if (a == b) {
            System.out.println("Self loop is not allowed.");
            return;
        }
        if (adj.get(a).contains(b)) {
            System.out.println("Edge already exists.");
            return;
        }
        adj.get(a).add(b);
        adj.get(b).add(a);
        System.out.println("Edge " + a + " - " + b + " added.");
    }
}

    public void display() {
        if (adj.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    // BFS using Queue - O(V + E). Returns steps count
    public int bfs(int start) {
        if (!hasVertex(start)) {
            System.out.println("Start vertex not found.");
            return 0;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;
        visited.add(start);
        queue.add(start);
        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            steps++;                         // visiting a vertex
            System.out.print(v + " ");
            for (int n : adj.get(v)) {
                steps++;                     // checking an edge
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
        System.out.println();
        return steps;
    }

    // DFS using recursion - O(V + E). Returns steps count
    public int dfs(int start) {
        if (!hasVertex(start)) {
            System.out.println("Start vertex not found.");
            return 0;
        }
        Set<Integer> visited = new HashSet<>();
        int[] steps = {0};
        System.out.print("DFS: ");
        dfsHelper(start, visited, steps);
        System.out.println();
        return steps[0];
    }

    private void dfsHelper(int v, Set<Integer> visited, int[] steps) {
        visited.add(v);
        steps[0]++;                          // visiting a vertex
        System.out.print(v + " ");
        for (int n : adj.get(v)) {
            steps[0]++;                      // checking an edge
            if (!visited.contains(n)) {
                dfsHelper(n, visited, steps);
            }
        }
    }
