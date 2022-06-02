package com.dsa.app.amazon;

public class _4_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int noOfIslands = 0;
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++){
            for(int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++){
                if(grid[rowIndex][colIndex] == '1'){
                    noOfIslands++;
                    dfs(grid, rowIndex, colIndex);
                }
            }
        }
        return noOfIslands;
    }

    public void dfs(char[][] grid, int rowIndex, int colIndex) {
        if(rowIndex < 0 || colIndex < 0 || rowIndex == grid.length || colIndex == grid[0].length || grid[rowIndex][colIndex] == '0'){
            return;
        }

        grid[rowIndex][colIndex] = '0';
        dfs(grid, rowIndex + 1, colIndex);
        dfs(grid, rowIndex, colIndex + 1);
        dfs(grid, rowIndex -1, colIndex);
        dfs(grid, rowIndex, colIndex - 1);

    }
}
