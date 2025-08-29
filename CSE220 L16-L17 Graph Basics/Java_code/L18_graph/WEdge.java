class WEdge {
    int source;
    int destination;
    int weight;
    WEdge next;

    public WEdge(int source, int destination, int weight, WEdge next) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.next = next;
    }
}