package org.isep;

import java.util.List;

public class WDiGraph extends Graph {

    private final List<WDiEdge> edges;

    public WDiGraph(int numberOfNodes, int numberOfEdges, List<WDiEdge> edges) {
        super(numberOfNodes, numberOfEdges);
        this.edges = edges;
    }

    public List<WDiEdge> adjacency() {return edges;}

}
