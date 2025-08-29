public class GraphUndirectedMatrix {
    private int numVertices;
    private int[][] adjMatrix;

    // Constructor
    public GraphUndirectedMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Method to add edges
    public void addEdges(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1; // Since the graph is undirected
        }
    }

    // Method to print adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to find and print neighbors of a given vertex
    public void findNeighbors(int vertex) {
        System.out.print("\nNeighbors of vertex " + vertex + ": ");
        boolean first = true;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == 1) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges1 = {
            {0, 1}, {0, 2},
            {1, 3}, {1, 4},
            {2, 3}
        };

        GraphUndirectedMatrix graph1 = new GraphUndirectedMatrix(numVertices);
        System.out.println("Before putting connections:");
        graph1.printMatrix();

        graph1.addEdges(edges1);
        System.out.println("\nAfter putting connections:");
        graph1.printMatrix();

        for (int i = 0; i < numVertices; i++) {
            graph1.findNeighbors(i);
        }

        System.out.println("\n---\n");

        int[][] edges2 = {
            {0, 1}, {0, 3},
            {1, 3}, {1, 2}, {1, 4},
            {2, 4},
            {3, 4}
        };

        GraphUndirectedMatrix graph2 = new GraphUndirectedMatrix(numVertices);
        System.out.println("Before putting connections:");
        graph2.printMatrix();

        graph2.addEdges(edges2);
        System.out.println("\nAfter putting connections:");
        graph2.printMatrix();

        for (int i = 0; i < numVertices; i++) {
            graph2.findNeighbors(i);
        }
    }
}
