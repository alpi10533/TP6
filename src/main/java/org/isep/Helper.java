package org.isep;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static Node searchNodeByNameWithDiEdges(List<DiEdge> diEdges, String name) {
        for (Edge edge : diEdges) {
            if (edge.from().name().equals(name)) {
                return edge.from();
            } else if (edge.to().name().equals(name)) {
                return edge.to();
            }
        }
        return null;
    }

    public static Node searchNodeByNameWithWDiEdges(List<WDiEdge> wDiEdges, String name) {
        for (Edge edge : wDiEdges) {
            if (edge.from().name().equals(name)) {
                return edge.from();
            } else if (edge.to().name().equals(name)) {
                return edge.to();
            }
        }
        return null;
    }

    public static List<Node> searchNeighborsByNodeWithDiEdges(List<DiEdge> diEdges, Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (Edge edge : diEdges) {
            if (edge.from().equals(node)) {
                neighbors.add(edge.to());
            }
        }
        return neighbors;
    }

}
