package com.dsa.app.final450.graphs.depthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class _547_NumberOfProvinces {
    public static void main(String[] args) {

    }

    /*
     * 100% faster.*/
    public int findCircleNumDFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int connectedComponents = 0;
        for (int mainVertexIndex = 0; mainVertexIndex < isConnected.length; mainVertexIndex++) {
            if (!visited[mainVertexIndex]) {
                dfs(isConnected, mainVertexIndex, visited);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    private void dfs(int[][] isConnected, int mainVertexIndex, boolean[] visited) {
        for (int connectedVertex = 0; connectedVertex < isConnected.length; connectedVertex++) {
            if (isConnected[mainVertexIndex][connectedVertex] == 1 && !visited[connectedVertex]) {
                visited[connectedVertex] = true;
                dfs(isConnected, connectedVertex, visited);
            }
        }
    }

    /*
     * Only 20% faster
     * */
    public int findCircleNumBFS(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int connectedComponents = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int mainVertexIndex = 0; mainVertexIndex < isConnected.length; mainVertexIndex++) {
            if (!visited[mainVertexIndex]) {
                queue.add(mainVertexIndex);
                while (queue.size() > 0) {
                    int currentVertex = queue.remove();
                    visited[currentVertex] = true;
                    for (int connectedVertex = 0; connectedVertex < isConnected.length; connectedVertex++) {
                        if (isConnected[currentVertex][connectedVertex] == 1 && !visited[connectedVertex]) {
                            queue.add(connectedVertex);
                        }
                    }
                }
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    int[] root;
    int[] rank;

    /*
     * 100% faster.*/
    public int findCircleNumDisjointSet(int[][] isConnected) {
        root = new int[isConnected.length];
        rank = new int[isConnected.length];
        for (int index = 0; index < isConnected.length; index++) {
            root[index] = index;
            rank[index] = 1;
        }

        for (int mainVertex = 0; mainVertex < isConnected.length; mainVertex++) {
            for (int subVertex = 0; subVertex < isConnected.length; subVertex++) {
                if (isConnected[mainVertex][subVertex] == 1 && mainVertex != subVertex) {
                    union(mainVertex, subVertex);
                }
            }
        }

        int connectedComponents = 0;
        for (int index = 0; index < root.length; index++) {
            if (index == root[index])
                connectedComponents++;
        }
        return connectedComponents;
    }

    private int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] = 1;
            }
        }
    }
}
