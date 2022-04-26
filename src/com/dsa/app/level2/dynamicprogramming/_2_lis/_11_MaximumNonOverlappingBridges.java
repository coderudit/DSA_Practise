package com.dsa.app.level2.dynamicprogramming._2_lis;

import java.util.Arrays;
import java.util.Scanner;

public class _11_MaximumNonOverlappingBridges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        /*
        * 9
        87 68
        57 35
        18 97
        3 65
        54 97
        87 53
        88 49
        62 43
        97 26
        */
        Bridge[] bridges = new Bridge[n];
        for (int index = 0; index < n; index++) {
            int north = scanner.nextInt();
            int south = scanner.nextInt();
            bridges[index] = new Bridge(north, south);
        }

        Arrays.sort(bridges);

        _11_MaximumNonOverlappingBridges program = new _11_MaximumNonOverlappingBridges();
        program.maximumNonOverlappingBridges(bridges);
    }

    private void maximumNonOverlappingBridges(Bridge[] bridges) {
        int[] dp = new int[bridges.length];
        int overallMax = 0;
        for (int index = 0; index < dp.length; index++) {
            int max = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                if (bridges[innerIndex].s <= bridges[index].s && dp[innerIndex] > max) {
                    max = dp[innerIndex];
                }
            }

            dp[index] = max + 1;
            if (dp[index] > overallMax) {
                overallMax = dp[index];
            }
        }
        System.out.println(overallMax);
    }

    static class Bridge implements Comparable<Bridge> {
        int n;
        int s;

        public Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        @Override
        public int compareTo(Bridge o) {
            if (this.n != o.n) {
                return this.n - o.n;
            } else {
                return this.s - o.s;
            }
        }
    }
}
