public class GraphDirectedWeightedAdjacencyList {
    private int numVertices;
    private WEdge[] adjList;

    public GraphDirectedWeightedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new WEdge[numVertices]; // Initialize the adjacency list
    }

    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];
            addEdge(source, destination, weight);
        }
    }

    public void addEdge(int source, int destination, int weight) {
        WEdge newEdge = new WEdge(source, destination, weight, adjList[source]);
        adjList[source] = newEdge;
    }

    public void printList() {
        System.out.println("Adjacency List with Weights:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            WEdge current = adjList[i];
            while (current != null) {
                System.out.print("(" + current.destination + ", " + current.weight + ") ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void findNeighbors(int vertex) {
        System.out.print("\nNeighbors of vertex " + vertex + ": ");
        WEdge current = adjList[vertex];
        while (current != null) {
            System.out.print("(" + current.destination + ", " + current.weight + ")");
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1, 2}, {0, 3, 6},
            {1, 2, 3}, {1, 4, 5},
            {3, 1, 4}, {3, 4, 2},
            {4, 2, 1}
        };

        GraphDirectedWeightedAdjacencyList graph = new GraphDirectedWeightedAdjacencyList(numVertices);

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