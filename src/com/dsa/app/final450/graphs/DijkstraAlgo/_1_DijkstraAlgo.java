package com.dsa.app.final450.graphs.DijkstraAlgo;

import java.util.*;

public class _1_DijkstraAlgo {
    private List<List<NodeWeightPair>> adjacentLists;

    public static void main(String[] args) {

    }

    public void createAdjacentLists(int[][] edges) {
        adjacentLists = new ArrayList<>();
        for (int index = 0; index < edges.length; index++) {
            if (adjacentLists.get(index) == null) {

            }
        }
    }

    public void implementDijkstraAlgo(int vertices, int startVertex, List<List<NodeWeightPair>> adjacentLists) {
        TreeMap<Integer, Integer> distanceQueue = new TreeMap<>();
        int[] distVertices = new int[vertices];
        Arrays.fill(distVertices, Integer.MAX_VALUE);
        distVertices[startVertex] = 0;
        distanceQueue.put(0, startVertex);

        while (distanceQueue.size() > 0) {
            var currentNode = distanceQueue.pollFirstEntry();
            var neighbors = adjacentLists.get(currentNode.getValue());

            for (var neighbor : neighbors) {
                int weightFromCurrentNode = currentNode.getKey() + neighbor.getWeight();

                if (distVertices[neighbor.getNode()] > weightFromCurrentNode) {
                    distVertices[neighbor.getNode()] = weightFromCurrentNode;
                    distanceQueue.put(neighbor.getNode(), weightFromCurrentNode);
                }
            }

        }
    }
}

class NodeWeightPair {
    private int weight;
    private int node;

    public NodeWeightPair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }
}

class DistanceNodePair {
    private int distance;
    private int node;

    public DistanceNodePair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }
}
