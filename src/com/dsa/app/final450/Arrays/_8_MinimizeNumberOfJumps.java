package com.dsa.app.final450.Arrays;

public class _8_MinimizeNumberOfJumps {
    public static void main(String[] args) {
        _8_MinimizeNumberOfJumps obj = new _8_MinimizeNumberOfJumps();
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        int[] arr1 = {0, 3, 5, 6, 9};
        System.out.println(obj.minJumps(arr));
    }

    int minJumps(int[] arr) {
        Integer[] jumpsFromCurrentIndex = new Integer[arr.length];
        jumpsFromCurrentIndex[arr.length - 1] = 0;

        for (int index = arr.length - 2; index >= 0; index--) {
            int steps = arr[index];

            int minJumps = Integer.MAX_VALUE;
            for (int stepIndex = 1; stepIndex <= steps && index + stepIndex < arr.length; stepIndex++) {
                if (jumpsFromCurrentIndex[index + stepIndex] != null && jumpsFromCurrentIndex[index + stepIndex] < minJumps)
                    minJumps = jumpsFromCurrentIndex[index + stepIndex];
            }


            if (minJumps != Integer.MAX_VALUE)
                jumpsFromCurrentIndex[index] = minJumps + 1;
        }

        return jumpsFromCurrentIndex[0];
    }

    int minJumpsRec(int[] arr, int currentIndex, int totalJumps) {
        if (currentIndex >= arr.length - 1) {
            return totalJumps;
        }

        return minJumpsRec(arr, currentIndex + arr[currentIndex], totalJumps + 1);
    }


}
