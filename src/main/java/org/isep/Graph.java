package org.isep;

public abstract class Graph {
    
    private final int numberOfNodes;
    private final int numberOfEdges;

    public Graph(int numberOfNodes, int numberOfEdges) {
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = numberOfEdges;
    }

    public int order() {
        return numberOfNodes;
    }
    public int size() {
        return numberOfEdges;
    }

}
