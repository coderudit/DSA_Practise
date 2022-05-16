package com.dsa.app.leetcode.contest293;

import java.util.Arrays;

public class Program2 {

    public static void main(String[] args) {
        Program2 program = new Program2();
        int bottom = 6;
        int top = 8;
        int[] special = {7, 6, 8};
        System.out.println(program.maxConsecutive(bottom, top, special));
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int overallMax = 0;
        for (int index = 0; index < special.length; index++) {
            int currentMax = special[index] - bottom;
            bottom = special[index] + 1;
            if (currentMax > overallMax) {
                overallMax = currentMax;
            }
        }
        bottom -= 1;
        if (top - bottom > overallMax)
            overallMax = top - bottom;
        return overallMax;
    }
}

