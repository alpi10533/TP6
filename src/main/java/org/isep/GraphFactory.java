package org.isep;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GraphFactory {

    public static DiGraph createDiGraphFromTextFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            ArrayList<DiEdge> edges = new ArrayList<>();
            int numberOfNodes = 0;
            int numberOfEdges = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];
                Node source = Helper.searchNodeByNameWithDiEdges(edges, name);
                if (source == null) {
                    source = new Node(name);
                    numberOfNodes++;
                }
                name = parts[1];
                Node destination = Helper.searchNodeByNameWithDiEdges(edges, name);
                if (destination == null) {
                    destination = new Node(name);
                    numberOfNodes++;
                }
                edges.add(new DiEdge(source, destination));
                numberOfEdges++;
            }
            return new DiGraph(numberOfNodes, numberOfEdges, edges);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static WDiGraph createWDiGraphFromTextFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            ArrayList<WDiEdge> edges = new ArrayList<>();
            int numberOfNodes = 0;
            int numberOfEdges = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];
                Node source = Helper.searchNodeByNameWithWDiEdges(edges, name);
                if (source == null) {
                    source = new Node(name);
                    numberOfNodes++;
                }
                name = parts[1];
                Node destination = Helper.searchNodeByNameWithWDiEdges(edges, name);
                if (destination == null) {
                    destination = new Node(name);
                    numberOfNodes++;
                }
                double weight = Double.parseDouble(parts[2]);
                edges.add(new WDiEdge(source, destination, weight));
                numberOfEdges++;
            }
            return new WDiGraph(numberOfNodes, numberOfEdges, edges);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
