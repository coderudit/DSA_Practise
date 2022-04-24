package com.dsa.app.level2.dynamicprogramming;

public class _1_LargestSquareSubMatrix {
    public static void main(String[] args) {
        _1_LargestSquareSubMatrix program = new _1_LargestSquareSubMatrix();
        int[][] matrix = {{0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1}};
        program.squareMatrix(matrix);
    }

    private void squareMatrix(int[][] matrix) {
        // This stores the size of matrix possible with this
        // as top left location of the matrix. Team is as strong as the weakest link.
        int[][] subMatrix = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int rowIndex = matrix.length - 1; rowIndex >= 0; rowIndex--) {
            for (int colIndex = matrix[0].length - 1; colIndex >= 0; colIndex--) {
                //Store the same value when last row, last column or value is 0
                //for any other row and column.
                if (rowIndex == matrix.length - 1 || colIndex == matrix[0].length - 1
                        || matrix[rowIndex][colIndex] == 0) {
                    subMatrix[rowIndex][colIndex] = matrix[rowIndex][colIndex];
                } else {
                    subMatrix[rowIndex][colIndex] = Math.min(
                            Math.min(subMatrix[rowIndex][colIndex + 1],
                                    subMatrix[rowIndex + 1][colIndex + 1]),
                            subMatrix[rowIndex + 1][colIndex]) + 1;
                    if (subMatrix[rowIndex][colIndex] > max)
                        max = subMatrix[rowIndex][colIndex];
                }
            }
        }
        System.out.println(max);
    }
}
