package org.isep;

import java.util.List;

public class DiGraph extends Graph {

    private final List<DiEdge> edges;

    public DiGraph(int numberOfNodes, int numberOfEdges, List<DiEdge> edges) {
        super(numberOfNodes, numberOfEdges);
        this.edges = edges;
    }

    public List<DiEdge> adjacency() {return edges;}

}
