public class GraphDirectedUnweightedMatrix {
    private int numVertices;
    private int[][] adjMatrix;

    // Constructor
    public GraphDirectedUnweightedMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Method to add edges for a directed graph (using regular for loop)
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjMatrix[u][v] = 1; // Only mark u -> v, because it's directed
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
        int[][] edges = {
            {0, 1}, {0, 2},
            {1, 0}, {1, 2}, {1, 3},
            {2, 1},
            {3, 2}, {3, 4},
            {4, 0}, {4, 2}
        };

        GraphDirectedUnweightedMatrix graph = new GraphDirectedUnweightedMatrix(numVertices);

        System.out.println("Before putting connections:");
        graph.printMatrix();

        System.out.println("\nAfter putting connections:");
        graph.addEdges(edges);
        graph.printMatrix();

        for (int i = 0; i < numVertices; i++) {
            graph.findNeighbors(i);
        }
    }
}
