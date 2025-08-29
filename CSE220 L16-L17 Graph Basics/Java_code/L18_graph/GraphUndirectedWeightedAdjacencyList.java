public class GraphUndirectedWeightedAdjacencyList {
    private int numVertices;
    private WEdge[] adjList;

    public GraphUndirectedWeightedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new WEdge[numVertices]; // Initialize heads
    }

    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];
            addEdge(source, destination, weight);
            addEdge(destination, source, weight);
        }
    }

    private void addEdge(int source, int destination, int weight) {
        WEdge newEdge = new WEdge(source, destination, weight, adjList[source]);
        adjList[source] = newEdge;
    }

    public void findNeighbors(int vertex) {
        System.out.print("\nNeighbors of vertex " + vertex + ": ");
        WEdge cur = adjList[vertex];
        boolean first = true;
        while (cur != null) {
            if (!first) System.out.print(", ");
            System.out.print("(" + cur.destination + ", " + cur.weight + ")");
            first = false;
            cur = cur.next;
        }
        System.out.println();
    }

    public void printList() {
        System.out.println("Adjacency List (Undirected, Weighted):");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            WEdge cur = adjList[i];
            while (cur != null) {
                System.out.print("(" + cur.destination + ", " + cur.weight + ") ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    // Driver
    public static void main(String[] args) {
        int numVertices = 5;

        // Provide each undirected edge only once to avoid duplicates in the list
        int[][] edges = {
            {0, 1, 2}, {0, 3, 6},
            {1, 2, 3}, {1, 4, 5},
            {3, 4, 2},
            {4, 2, 1}
        };

        GraphUndirectedWeightedAdjacencyList graph =
            new GraphUndirectedWeightedAdjacencyList(numVertices);

        System.out.println("Before adding connections:");
        graph.printList();

        graph.addEdges(edges);

        System.out.println("\nAfter adding connections:");
        graph.printList();

        for (int v = 0; v < numVertices; v++) {
            graph.findNeighbors(v);
        }
    }
}
