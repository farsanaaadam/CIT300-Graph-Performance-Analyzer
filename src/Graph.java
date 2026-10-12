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
