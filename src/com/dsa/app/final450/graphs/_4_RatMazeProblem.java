package com.dsa.app.final450.graphs;

import java.util.ArrayList;
import java.util.List;

public class _4_RatMazeProblem {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        String directions = "DLRU";
        int[] x = {1, 0, 0, -1}; //Corresponding matrix index of DLRU
        int[] y = {0, -1, 1, 0};

        _4_RatMazeProblem problem = new _4_RatMazeProblem();
        if(maze[0][0]==1) {
            maze[0][0] = 2;
            problem.mazePathHelper("", maze, 0, 0, x, y, directions);
        }
        for (int index = 0; index < mazePaths.size(); index++) {
            System.out.println(mazePaths.get(index));
        }
    }

    private static List<String> mazePaths = new ArrayList<String>();

    private void mazePathHelper(String path, int[][] maze, int row, int column, int[] x, int[] y, String directions) {
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            mazePaths.add(path);
            return;
        }

        for (int index = 0; index < directions.length(); index++) {
            int nextRow = row + x[index];
            int nextColumn = column + y[index];
            if (isValid(nextRow, nextColumn, maze)) {
                maze[nextRow][nextColumn] = 2;
                mazePathHelper(path + directions.charAt(index), maze, nextRow, nextColumn, x, y, directions);
                maze[nextRow][nextColumn] = 1;
            }

        }
    }

    private boolean isValid(int row, int column, int[][] maze) {
        if (row >= 0 && row < maze.length && column >= 0 && column < maze[0].length &&
                maze[row][column] == 1) {
            return true;
        }
        return false;
    }
}
