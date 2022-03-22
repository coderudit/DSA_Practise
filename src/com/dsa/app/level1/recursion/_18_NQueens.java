package com.dsa.app.level1.recursion;

public class _18_NQueens {
    public static void main(String[] args) throws Exception {
        int[][] queens = new int[4][4];
        printNQueens(queens, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if (chess.length == row) {
            System.out.println(qsf);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (chess[row][col] == 0
                    && isItSafeToPlaceQueen(chess, row, col) == true) {
                chess[row][col] = 1;
                printNQueens(chess,
                        qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }

        }
    }

    private static boolean isItSafeToPlaceQueen(int[][] queens, int row, int col) {
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (queens[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col; i >= 0; i--) {
            if (queens[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0
                && j < queens.length; i--, j++) {
            if (queens[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col - 1; j >= 0; j--) {
            if (queens[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


}
