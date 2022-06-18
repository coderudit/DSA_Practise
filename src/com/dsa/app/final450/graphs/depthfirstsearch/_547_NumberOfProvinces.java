package com.dsa.app.final450.graphs.depthfirstsearch;

public class _547_NumberOfProvinces {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
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
            if(isConnected[mainVertexIndex][connectedVertex] == 1 && !visited[connectedVertex]){
                visited[connectedVertex] = true;
                dfs(isConnected, connectedVertex, visited);
            }
        }
    }
}
