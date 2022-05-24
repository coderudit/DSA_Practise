package com.dsa.app.final450.graphs.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _797_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        //int[][] graph = {{1, 2}, {3}, {3}, {}};
        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        //int[][] graph = {{1,2,3}, {2}, {3}, {}};
        var obj = new _797_AllPathsFromSourceToTarget();
        obj.allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int index = 0; index < graph.length; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        int destination = graph.length - 1;

        int index = 0;
        for (int[] edge : graph) {
            for (int vertex : edge) {
                adjacencyList.get(index).add(vertex);
            }
            index++;
        }

        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        stack.push(list);

        var visited = new boolean[graph.length];

        List<List<Integer>> paths = new ArrayList<>();
        while (stack.size() > 0) {
            var allEdges = stack.pop();
            var vertex = allEdges.get(allEdges.size() - 1);
            visited[vertex] = true;
            if (vertex == destination) {
                var path = new ArrayList();
                for (var item : allEdges) {
                    System.out.print(item + "->");
                    visited[item] = false;
                    path.add(item);
                }
                paths.add(path);
                System.out.println();
                continue;
            }

            for (var item : adjacencyList.get(vertex)) {
                if (!visited[item]) {
                    var newEdges = new ArrayList<>(allEdges);
                    newEdges.add(item);
                    stack.push(newEdges);
                }
            }

        }
        System.out.println();
        return paths;
    }

    public List<List<Integer>> allPathsSourceTargetRec(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode: nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
