package org.isep;

public class WDiEdge extends Edge {

    private final double weight;

    public WDiEdge(Node source, Node destination, double weight) {
        super(source, destination);
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

}