package com.dsa.app.leetcode.contest294;

public class Program4 {
    public static void main(String[] args) {
        Program4 program = new Program4();
        int[] strength = {1,3,1,2};
        program.totalStrength(strength);
    }

    public int totalStrength(int[] strength) {
        int[][] strengthArr = new int[strength.length][strength.length];

        int[] sum = new int[strength.length];
        int[] min = new int[strength.length];

        int prevMin = Integer.MAX_VALUE;
        for(int index = 0; index < strength.length; index++){
            min[index] = Math.min(prevMin, strength[index]);
            prevMin = Math.min(prevMin, strength[index]);
        }
        int prevSum = 0;
        for(int index = 0; index < strength.length; index++){
            min[index] = Math.min(prevMin, strength[index]);
        }
        for (int outerIndex = 0; outerIndex < strength.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < strength.length; innerIndex++) {
               // Math.min(strengthArr[outerIndex][innerIndex]=
            }
        }
        return -1;
    }
}
