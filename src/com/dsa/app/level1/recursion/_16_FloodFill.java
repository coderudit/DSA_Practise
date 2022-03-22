package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _16_FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    /***
     * Visited array uses the concept of DP which keeps track of the visited cells.
     * @param maze
     * @param sr
     * @param sc
     * @param asf
     * @param visited
     */
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {
        //Order of conditions matter, if maze[sr][sc] == 1 placed before, it will throw array index bound exception for negative or greater than array length.
        if (sr < 0 || sr > (maze.length - 1) || sc < 0 || sc > (maze.length - 1) || maze[sr][sc] == 1 || visited[sr][sc] == true) {
            return;
        }
        if (sr == maze.length - 1 && sc == maze[sr].length - 1) {
            System.out.println(asf);
            return;
        }
        visited[sr][sc] = true; // Ensures we don't visit the same cell again in this course path.
        floodfill(maze, sr - 1, sc, asf + "t", visited);
        floodfill(maze, sr, sc - 1, asf + "l", visited);
        floodfill(maze, sr + 1, sc, asf + "d", visited);
        floodfill(maze, sr, sc + 1, asf + "r", visited);
        visited[sr][sc] = false; // Ensures we are allowed to visit the same cell for alternate paths.
    }

}
