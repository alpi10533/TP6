package org.isep;

public abstract class Edge {

    private final Node source;
    private final Node destination;

    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }

    public Node from() {
        return source;
    }
    public Node to() {
        return destination;
    }

}