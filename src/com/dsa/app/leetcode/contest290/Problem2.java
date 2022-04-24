package com.dsa.app.leetcode.contest290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 program = new Problem2();
        int[][] circles1 = {{2, 2, 1}};
        int[][] circles2 = {{2, 2, 2}, {3, 4, 1}};
        int[][] circles3 = {{8, 9, 6}, {9, 8, 4}, {4, 1, 1}, {8, 5, 1}, {7, 1, 1}, {6, 7, 5}, {7, 1, 1}, {7, 1, 1}, {5, 5, 3}};
        program.countLatticePoints2(circles3);
    }

    private void countLatticePoints2(int[][] circles) {
        Set<String> pointPairs = new HashSet<>();
        for (int[] arr : circles) {

            int x = arr[0], y = arr[1], r = arr[2];

            for (int indexX = x - r; indexX <= x + r; indexX++) {
                for (int indexY = y - r; indexY <= y + r; indexY++) {
                    if ((x - indexX) * (x - indexX) + (y - indexY) * (y - indexY) <= r * r)
                        pointPairs.add(indexX + "," + indexY);
                }
            }

        }

        System.out.println(pointPairs.size());
    }
}
