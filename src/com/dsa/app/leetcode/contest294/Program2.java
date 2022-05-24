package com.dsa.app.leetcode.contest294;

import java.util.Arrays;

public class Program2 {
    public static void main(String[] args) {
        Program2 program = new Program2();
        int[] capacity = {10,2,2};
        int[] rocks = {2,2,0};
        int additionalRocks = 100;
        System.out.println(program.maximumBags(capacity, rocks, additionalRocks));
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diffArr = new int[capacity.length];

        for (int index = 0; index < capacity.length; index++) {
            diffArr[index] = capacity[index] - rocks[index];
        }

        Arrays.sort(diffArr);

        int bagCount = 0;
        for (int index = 0; index < capacity.length; index++) {
            //When bags are already filled.
            if (diffArr[index] == 0) {
                bagCount++;
            } //When additional rocks fill the bag
            else if (additionalRocks - diffArr[index] >= 0) {
                additionalRocks = additionalRocks - diffArr[index];
                bagCount++;
            }
        }
        return bagCount;
    }
}
