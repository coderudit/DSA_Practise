package com.dsa.app.final450.graphs;

import java.util.Stack;

public class GraphAdjacencyMatrix {
    private boolean adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    public GraphAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    public void addEdge(int i, int j) {
        //For an undirected graph
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());

        int[] arr = {0,1,2,3};
        g.traverseVertex(arr);
    }

    public void traverseVertex(int[] arr) {
        int[] visited = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);

        while (stack.size() > 0) {
            int element = stack.pop();
            if (visited[element] != -1) {
                visited[element] = -1;
                System.out.println(element);

                for(var row = 0; row < arr.length; row++){
                    for(var col = 0; col < arr.length; col++){
                        if(adjMatrix[element][col]){
                            stack.push(col);
                        }
                    }
                }
            }
        }
    }
}
