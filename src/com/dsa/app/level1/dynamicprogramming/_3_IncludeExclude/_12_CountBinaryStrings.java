package com.dsa.app.level1.dynamicprogramming._3_IncludeExclude;

public class _12_CountBinaryStrings {
    public static void main(String[] args) {
        _12_CountBinaryStrings program = new _12_CountBinaryStrings();
        //System.out.println(program.countConsecutive0s(6));
        System.out.println(program.countConsecutive1s(1));
        System.out.println(program.countConsecutive1s(2));
        System.out.println(program.countConsecutive1s(6));
    }

    private int countConsecutive0s(int n) {
        int old0Count = 1;
        int old1Count = 1;

        for (int index = 2; index <= n; index++) {
            int new0Count = old1Count;
            int new1Count = old0Count + old1Count;

            old0Count = new0Count;
            old1Count = new1Count;
        }
        return old0Count + old1Count;
    }

    //600. Non-negative Integers without Consecutive Ones
    private int countConsecutive1s(int n) {
        int old0Count = 1;
        int old1Count = 1;

        for (int index = 2; index <= n; index++) {
            int new0Count = old0Count + old1Count;
            int new1Count = old1Count;

            old0Count = new0Count;
            old1Count = new1Count;
        }
        return old0Count + old1Count;
    }
}
