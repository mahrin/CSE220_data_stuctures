public class GraphUndirectedAdjacencyList {
    private int numVertices;
    private Edge[] adjList;

    // Constructor
    public GraphUndirectedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new Edge[numVertices]; // Initialize the adjacency list array
    }

    // Method to add edges for an undirected graph
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            addEdge(source, destination);
            addEdge(destination, source); // Because it's undirected
        }
    }

    // Helper method to add an edge from source to destination
    private void addEdge(int source, int destination) {
        Edge newEdge = new Edge(source, destination, adjList[source]);
        adjList[source] = newEdge;
    }

    // Method to print the adjacency list
    public void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            Edge current = adjList[i];
            while (current != null) {
                System.out.print(current.destination + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Method to find and print neighbors of a given vertex
    public void findNeighbors(int vertex) {
        System.out.print("\nNeighbors of vertex " + vertex + ": ");
        Edge current = adjList[vertex];
        boolean first = true;
        while (current != null) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(current.destination);
            first = false;
            current = current.next;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1},
            {0, 3},
            {1, 3},
            {1, 2},
            {1, 4},
            {2, 4},
            {3, 4}
        };

        GraphUndirectedAdjacencyList graph = new GraphUndirectedAdjacencyList(numVertices);

        System.out.println("Before adding connections:");
        graph.printList();

        graph.addEdges(edges);

        System.out.println("\nAfter adding connections:");
        graph.printList();

        for (int vertex = 0; vertex < numVertices; vertex++) {
            graph.findNeighbors(vertex);
        }
    }
}