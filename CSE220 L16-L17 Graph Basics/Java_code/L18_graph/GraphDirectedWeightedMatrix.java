public class GraphDirectedWeightedMatrix {
    private int numVertices;
    private int[][] adjMatrix;

    // Constructor
    public GraphDirectedWeightedMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Method to add edges with weights for a directed graph
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adjMatrix[u][v] = weight; // Assign the weight to edge from u to v
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
            if (adjMatrix[vertex][i] != 0) { // Neighbor if weight is non-zero
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
            {0, 1, 2}, // Edge from 0 to 1 with weight 2
            {0, 2, 3}, // Edge from 0 to 2 with weight 3
            {1, 3, 4}, // Edge from 1 to 3 with weight 4
            {1, 4, 5}, // Edge from 1 to 4 with weight 5
            {2, 3, 6}  // Edge from 2 to 3 with weight 6
        };

        GraphDirectedWeightedMatrix graph = new GraphDirectedWeightedMatrix(numVertices);

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
