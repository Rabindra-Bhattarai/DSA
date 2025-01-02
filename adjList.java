import java.util.List;
import java.util.ArrayList;

// Import the linkedlist class

public class adjList {
    public linkedlist adjList[];
    public int vertices;

    public adjList(int vertices) {
        this.vertices = vertices;
        adjList = new linkedlist[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new linkedlist();
        }
    }

    public void addEdges(int u, int v) {
        adjList[u].addNode(v);
        adjList[v].addNode(u);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            linkedlist.Node current = adjList[i].head;
            while (current != null) {
                System.out.print(current.data + " , ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public List<Integer> getAdjacentNode(int i) {
        List<Integer> adjNodes = new ArrayList<>();
        linkedlist.Node current = adjList[i].head;
        while (current != null) {
            adjNodes.add(current.data);
            current = current.next;
        }
        return adjNodes;
    }

    public static void main(String[] args) {
        adjList adj = new adjList(5);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);

        // Print the graph
        adj.printGraph();

        // Get adjacent nodes for vertex 1
        System.out.println("Adjacent nodes for vertex 1: " + adj.getAdjacentNode(1));
    }
}
