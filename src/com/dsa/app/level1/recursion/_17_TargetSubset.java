package com.dsa.app.level1.recursion;

public class _17_TargetSubset {
    public static void main(String[] args) throws Exception {
        int[] arr = {5, 10, 20, 30, 40, 50, 60};
        _17_TargetSubset.printTargetSumSubsets(arr, 0, "", 0, 60);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if (idx == arr.length || sos > tar) {
            return;
        }
        if (sos == tar) {
            System.out.println(set);
            return;
        }


        printTargetSumSubsets(arr, idx + 1, set + arr[idx], sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}
