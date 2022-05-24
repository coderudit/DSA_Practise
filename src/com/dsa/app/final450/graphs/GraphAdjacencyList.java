package com.dsa.app.final450.graphs;

import java.util.*;

public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjLists;
    private boolean visited[];
    private int distance[];

    // Graph creation
    GraphAdjacencyList(int vertices) {
        adjLists = new HashMap<>();
        visited = new boolean[vertices];
        distance = new int[vertices];
        for (int i = 0; i < vertices; i++)
            adjLists.put(i, new LinkedList<>());
    }

    // Add edges
    //direction = 0 -> undirected
    //direction = 1 -> directed
    void addEdge(int src, int dest, boolean direction) {
        if (direction == false) {
            adjLists.get(dest).add(src);
        }
        adjLists.get(src).add(dest);
    }

    //BFS algorithm
    void BFS(int vertex, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);

        distance[vertex] = 0;
        while (queue.size() > 0) {
            var currentNode = queue.remove();
            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            System.out.println(currentNode + " at distance " + distance[currentNode]);

            var neighbours = adjLists.get(currentNode);
            for (var item : neighbours) {
                distance[item] = distance[currentNode] + 1;
                queue.add(item);
            }
        }
    }

    boolean detectCycleInUndirectedGraphsWithBFS(int parent, boolean[] visited, Map<Integer, Integer> childParentMap) {
        childParentMap.put(parent, -1);
        visited[parent] = true;
        Queue<Integer> queue = new ArrayDeque();
        queue.add(parent);

        while (queue.size() > 0) {
            int element = queue.remove();
            for (var item : adjLists.get(element)) {
                //visited[1] = true && 2 => 1 == 1
                //i.e. if this neighbor was visited as a parent to this neighbor
                if (visited[item] && childParentMap.get(element) != item) {
                    return true;
                } else if (!visited[item]) {
                    visited[item] = true;
                    queue.add(item);
                    childParentMap.put(item, element);
                }
            }
        }
        return false;
    }

    // DFS algorithm
    void DFS(int vertex, boolean[] visited) {
        if (visited[vertex])
            return;
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (var item : adjLists.get(vertex)) {
            DFS(item, visited);
        }

    }

    boolean detectCycleInUndirectedGraphsWithDFS(int current, int parent, boolean[] visited) {
        visited[current] = true;

        for (var item : adjLists.get(current)) {
            if (!visited[item]) {
                boolean hasCycle = detectCycleInUndirectedGraphsWithDFS(item, current, visited);
                if (hasCycle)
                    return true;
            } else if (parent != item) {
                return true;
            }

        }
        return false;
    }

    boolean detectCycleInDirectedGraphsWithDFS(int vertex, boolean[] visited, boolean[] dfs_visited){
        visited[vertex] = true;
        dfs_visited[vertex] = true;

        for(var item: adjLists.get(vertex)){
            if(dfs_visited[item]){
                return true;
            }else if(!visited[item]){
                boolean hasCycle = detectCycleInDirectedGraphsWithDFS(item, visited, dfs_visited);
                if(hasCycle)
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int vertices = 6; //Actual it's for 5 index
        var undirectedGraph = new GraphAdjacencyList(vertices);

        //Undirected graph
        undirectedGraph.addEdge(1, 2, false);
        undirectedGraph.addEdge(1, 4, false);
        undirectedGraph.addEdge(2, 3, false);
        undirectedGraph.addEdge(2, 5, false);
        undirectedGraph.addEdge(3, 5, false);

        System.out.println("Following is Depth First Traversal");

        boolean[] visited = new boolean[vertices];
        for (int index = 0; index < vertices; index++) { //To take care of disconnected components
            if (!visited[index])
                undirectedGraph.BFS(index, visited);
        }

        // 3. Detect cycle in undirected graphs
        Map<Integer, Integer> childParentMap = new HashMap<>();
        childParentMap.put(1, -1);

        boolean hasCycle = false;
        for (int index = 1; index < vertices; index++) {
            if (!visited[index]) {
                hasCycle = undirectedGraph.detectCycleInUndirectedGraphsWithBFS(index, visited, childParentMap);
                if (hasCycle) {
                    System.out.println("Graph has cycle.");
                    break;
                }
            }
        }

    }
}
