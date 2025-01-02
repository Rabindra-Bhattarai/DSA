import java.util.ArrayList;
import java.util.List;

public class adjMatrix {
    int[][] matrix;
    int vertices;

    adjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdges(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    void printGraph() { // graph print
        for (int i = 0; i < vertices; i++) { // row
            System.out.print(i + " is connected to ");
            for (int j = 0; j < vertices; j++) { // column
                if (matrix[i][j] != 0) { // i,j are connected
                    System.out.print(j + ", ");
                }
            }
            System.out.println(); // Move to the next line after printing connections for one vertex
        }
    }

    List<Integer> getAdjNodes(int i) {
        List<Integer> adjnodes = new ArrayList<>();
        for (int j = 0; j < vertices; j++) {
            // column
            if (matrix[i][j] != 0) {
                adjnodes.add(j);
            }
        }
        return adjnodes;
    }

    void printMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        adjMatrix adj = new adjMatrix(5);
        adj.addEdges(0, 1);
        adj.addEdges(0, 2);
        adj.addEdges(1, 3);
        adj.addEdges(1, 4);
        adj.addEdges(2, 3);
        adj.addEdges(3, 4);
        adj.printGraph();

        System.out.println("Matrix representation:");
        adj.printMatrix();

        System.out.println("Adjacent nodes of vertex 1: " + adj.getAdjNodes(1));
    }
}
