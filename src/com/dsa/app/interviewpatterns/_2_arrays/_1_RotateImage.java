package com.dsa.app.interviewpatterns._2_arrays;

public class _1_RotateImage {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int firstIndex = 0; firstIndex < matrix.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < matrix.length; secondIndex++) {
                int temp = matrix[firstIndex][secondIndex];
                matrix[firstIndex][secondIndex] =  matrix[secondIndex][firstIndex] ;
                matrix[secondIndex][firstIndex] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        for (int firstIndex = 0; firstIndex < matrix.length; firstIndex++) {
            for (int secondIndex = 0; secondIndex < matrix.length / 2; secondIndex++) {
                int temp = matrix[firstIndex][secondIndex];
                matrix[firstIndex][secondIndex] = matrix[firstIndex][matrix.length - secondIndex - 1];
                matrix[firstIndex][matrix.length - secondIndex - 1] = temp;
            }
        }
    }
}
