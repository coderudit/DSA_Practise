package com.dsa.app.leetcode.graphs.depthfirstsearch;

import java.util.*;

public class _1971_FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        var result = validPath(edges.length, edges, 0, 2);
        System.out.println(result);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        //Add edges for a bi-directed graph.
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);

        while(!stack.isEmpty()){
            int node = stack.pop();

            if(node == destination){
                return true;
            }

            if(visited[node]){
                continue;
            }

            for(int neighbor : adjacencyList.get(node)){
                stack.push(neighbor);
            }
        }

        return false;
    }
}
