import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static ArrayOperations array = new ArrayOperations(20);
    private static StackOperations stack = new StackOperations(10);
    private static QueueOperations queue = new QueueOperations(10);
    private static LinkedListOperations list = new LinkedListOperations();
    private static Graph graph = new Graph();
    private static PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    // Input validation: keeps asking until a valid integer is entered
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=============================================");
            System.out.println("DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: listMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: analyzer.displayAllResults(); break;
                case 9: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice! Enter 1 to 9.");
            }
        } while (choice != 9);
    }

    private static void arrayMenu() {
        int c;
        do {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. Display\n5. Return to Main Menu");
            c = readInt("Enter your choice: ");
            switch (c) {
                case 1: array.insert(readInt("Enter value: ")); break;
                case 2: array.delete(readInt("Enter value to delete: ")); break;
                case 3:
                    int v = readInt("Enter value to search: ");
                    int idx = array.search(v);
                    System.out.println(idx == -1 ? "Not found." : "Found at index " + idx);
                    break;
                case 4: array.display(); break;
                case 5: break;
                default: System.out.println("Invalid choice!");
            }
        } while (c != 5);
    }

    private static void stackMenu() {
        int c;
        do {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return to Main Menu");
            c = readInt("Enter your choice: ");
            switch (c) {
                case 1: stack.push(readInt("Enter value: ")); break;
                case 2: stack.pop(); break;
                case 3: stack.peek(); break;
                case 4: stack.display(); break;
                case 5: break;
                default: System.out.println("Invalid choice!");
            }
        } while (c != 5);
    }

    private static void queueMenu() {
        int c;
        do {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek/Front\n4. Display\n5. Return to Main Menu");
            c = readInt("Enter your choice: ");
            switch (c) {
                case 1: queue.enqueue(readInt("Enter value: ")); break;
                case 2: queue.dequeue(); break;
                case 3: queue.peek(); break;
                case 4: queue.display(); break;
                case 5: break;
                default: System.out.println("Invalid choice!");
            }
        } while (c != 5);
    }

    private static void listMenu() {
        int c;
        do {
            System.out.println("\n----------- LINKED LIST OPERATIONS ----------");
            System.out.println("1. Insert at Front\n2. Insert at End\n3. Delete\n4. Search\n5. Display\n6. Return to Main Menu");
            c = readInt("Enter your choice: ");
            switch (c) {
                case 1: list.insertAtFront(readInt("Enter value: ")); break;
                case 2: list.insertAtEnd(readInt("Enter value: ")); break;
                case 3: list.delete(readInt("Enter value to delete: ")); break;
                case 4: list.search(readInt("Enter value to search: ")); break;
                case 5: list.display(); break;
                case 6: break;
                default: System.out.println("Invalid choice!");
            }
        } while (c != 6);
    }

    private static void searchMenu() {
        int c;
        do {
            System.out.println("\n-------------- SEARCHING OPERATIONS ---------");
            System.out.println("(Searches the numbers you inserted in Array Operations)");
            System.out.println("1. Linear Search\n2. Binary Search\n3. Compare Both\n4. Return to Main Menu");
            c = readInt("Enter your choice: ");
            if (c >= 1 && c <= 3) {
                int[] arr = array.toArray();
                if (arr.length == 0) {
                    System.out.println("Array is empty! Insert values in Array Operations first.");
                    continue;
                }
                int key = readInt("Enter value to search: ");
                int[] sorted = arr.clone();
                Arrays.sort(sorted);   // binary search needs sorted data

                if (c == 1 || c == 3) {
                    int[] r = SearchOperations.linearSearch(arr, key);
                    System.out.println("Linear Search: " + (r[0] == -1 ? "Not found" : "Found at index " + r[0]) + " | Steps: " + r[1]);
                    analyzer.addResult("Linear Search | key=" + key + " | steps=" + r[1]);
                }
                if (c == 2 || c == 3) {
                    int[] r = SearchOperations.binarySearch(sorted, key);
                    System.out.println("Binary Search (on sorted copy): " + (r[0] == -1 ? "Not found" : "Found at index " + r[0]) + " | Steps: " + r[1]);
                    analyzer.addResult("Binary Search | key=" + key + " | steps=" + r[1]);
                }
            } else if (c != 4) {
                System.out.println("Invalid choice!");
            }
        } while (c != 4);
    }

    private static void graphMenu() {
        int c;
        do {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal\n5. DFS Traversal\n6. Return to Main Menu");
            c = readInt("Enter your choice: ");
            switch (c) {
                case 1: graph.addVertex(readInt("Enter vertex number: ")); break;
                case 2:
                    int a = readInt("Enter first vertex: ");
                    int b = readInt("Enter second vertex: ");
                    graph.addEdge(a, b);
                    break;
                case 3: graph.display(); break;
                case 4:
                    if (graph.isEmpty()) { System.out.println("Graph is empty."); break; }
                    int s1 = readInt("Enter start vertex: ");
                    int steps1 = graph.bfs(s1);
                    System.out.println("Steps: " + steps1);
                    analyzer.addResult("Graph Traversal | BFS | start=" + s1 + " | steps=" + steps1);
                    break;
                case 5:
                    if (graph.isEmpty()) { System.out.println("Graph is empty."); break; }
                    int s2 = readInt("Enter start vertex: ");
                    int steps2 = graph.dfs(s2);
                    System.out.println("Steps: " + steps2);
                    analyzer.addResult("Graph Traversal | DFS | start=" + s2 + " | steps=" + steps2);
                    break;
                case 6: break;
                default: System.out.println("Invalid choice!");
            }
        } while (c != 6);
    }

    private static void performanceMenu() {
        int c;
        do {
            System.out.println("\n------------ PERFORMANCE COMPARISON ---------");
            System.out.println("1. Linear vs Binary Search (large array)\n2. BFS vs DFS (your graph)\n3. Return to Main Menu");
            c = readInt("Enter your choice: ");
            switch (c) {
                case 1:
                    int n = readInt("Enter array size (e.g. 10000): ");
                    if (n <= 0) { System.out.println("Size must be greater than 0."); break; }
                    analyzer.compareSearch(n);
                    break;
                case 2:
                    if (graph.isEmpty()) { System.out.println("Graph is empty. Add vertices and edges first."); break; }
                    analyzer.compareGraph(graph, readInt("Enter start vertex: "));
                    break;
                case 3: break;
                default: System.out.println("Invalid choice!");
            }
        } while (c != 3);
    }
}