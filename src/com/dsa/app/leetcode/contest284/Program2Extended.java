package com.dsa.app.leetcode.contest284;

public class Program2Extended {
    public static void main(String[] args) {
        Program2Extended obj = new Program2Extended();
        int[][] artifacts = {{0, 0, 0, 0}, {0, 1, 1, 1}};
        //int[][] artifacts = {{3, 1, 4, 1}, {1, 1, 2, 2}, {1, 0, 2, 0}, {4, 3, 4, 4}, {0, 3, 1, 4}, {2, 3, 3, 4}};
        int[][] dig = {{0, 0}, {0, 1}, {1,1}};


        //int[][] dig = {{0, 0}, {2, 1}, {2, 0}, {2, 3}, {4, 3}, {2, 4}, {4, 1}, {0, 2}, {4, 0}, {3, 1}, {1, 2}, {1, 3}, {3, 2}};
        obj.digArtifacts(2, artifacts, dig);
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] digger = new boolean[n][n];
        for (int digIndex = 0; digIndex < dig.length; digIndex++) {
            digger[dig[digIndex][0]][dig[digIndex][1]] = true;
        }
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < n; colIndex++) {
                System.out.print(digger[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }

        int count = 0;
        for (int artifactIndex = 0; artifactIndex < artifacts.length; artifactIndex++) {
            var item = artifacts[artifactIndex];
            if (traverseDigger(item[0], item[1], item[2], item[3], digger))
                count++;
        }
        return count;
    }

    boolean traverseDigger(int rowStart, int colStart, int rowEnd, int colEnd, boolean[][] digger) {
        if (rowStart == rowEnd && colStart == colEnd) {
            if (digger[rowStart][colStart] == false)
                return false;
            return true;
        }
        if (digger[rowStart][colStart] == false)
            return false;
        if (rowStart < rowEnd)
            if (!traverseDigger(rowStart + 1, colStart, rowEnd, colEnd, digger))
                return false;
        if (colStart < colEnd)
            return traverseDigger(rowStart, colStart + 1, rowEnd, colEnd, digger);
        return true;
    }
}
