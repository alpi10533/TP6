package org.isep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        firstTest();
        secondTest();
    }

    public static void firstTest() {
        DiGraph diGraph = GraphFactory.createDiGraphFromTextFile("C:/Users/alexa/OneDrive - ISEP/Documents/A2/Algotrithmie et programmation avancée/TPs/TP 6/Rendu/Code/src/main/resources/graph-DFS-BFS.txt");
        assert diGraph != null;
        System.out.println("\ngraph-DFS-BFS.txt");
        List<DiEdge> diEdges = diGraph.adjacency();
        for (int i = 0; i < diGraph.size(); i++) {
            DiEdge diEdge = diEdges.get(i);
            System.out.println("Edge N°" + (i +1) + " : " + diEdge.from().name() + " ----> " + diEdge.to().name());
        }
        WDiGraph wDiGraph = GraphFactory.createWDiGraphFromTextFile("C:/Users/alexa/OneDrive - ISEP/Documents/A2/Algotrithmie et programmation avancée/TPs/TP 6/Rendu/Code/src/main/resources/graph-WDG.txt");
        assert wDiGraph != null;
        System.out.println("\ngraph-WDG.txt");
        List<WDiEdge> wDiEdges = wDiGraph.adjacency();
        for (int i = 0; i < wDiGraph.size(); i++) {
            WDiEdge wDiEdge = wDiEdges.get(i);
            System.out.println("Edge N°" + (i +1) + " : " + wDiEdge.from().name() + " --(" + wDiEdge.weight() + ")--> " + wDiEdge.to().name());
        }
    }
    
    public static void secondTest() {
        DiGraph graph = GraphFactory.createDiGraphFromTextFile("C:/Users/alexa/OneDrive - ISEP/Documents/A2/Algotrithmie et programmation avancée/TPs/TP 6/Rendu/Code/src/main/resources/graph-DFS-BFS.txt");
        assert graph != null;
        System.out.println("\nDFS on graph-WDG.txt");
        List<Node> nodes = dfs(graph, "5");
        System.out.print("Order of the first encounter of the nodes : ");
        for (int i = 0; i < nodes.size(); i++) {
            if(i != 0) {
                System.out.print(" => ");
            }
            System.out.print(nodes.get(i).name());
        }
    }

    public static List<Node> dfs(DiGraph graph, String name) {
        Node start = Helper.searchNodeByNameWithDiEdges(graph.adjacency(), name);
        Node current;
        Stack<Node> fringe = new Stack<>();
        fringe.push(start);
        List<Node> closed = new ArrayList<>();
        HashMap<Node, Node> parents = new HashMap<>();
        parents.put(start, null);
        while (!fringe.isEmpty()) {
            current = fringe.pop();
            closed.add(current);
            for (Node neighbor : Helper.searchNeighborsByNodeWithDiEdges(graph.adjacency(), current)) {
                if (!closed.contains(neighbor)) {
                    fringe.push(neighbor);
                    parents.put(neighbor, current);
                }
            }
        }
        return new ArrayList<>(closed);
    }

}