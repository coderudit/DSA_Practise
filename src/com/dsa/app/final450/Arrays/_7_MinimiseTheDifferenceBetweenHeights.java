package com.dsa.app.final450.Arrays;

public class _7_MinimiseTheDifferenceBetweenHeights {
    public static void main(String[] args) {
        _7_MinimiseTheDifferenceBetweenHeights obj = new _7_MinimiseTheDifferenceBetweenHeights();
        int[] arr = {3, 9, 12, 16, 20};
        int n = arr.length;
        int k = 3;
        obj.getMinDiff(arr, n, k);
    }

    private int getMinDiff(int[] arr, int n, int k) {
        int val = getMinDiffRec(arr, n, k, 0);
        System.out.println(val);
        return val;
    }

    private int getMinDiffRec(int[] arr, int n, int k, int currentIndex) {
        if (currentIndex == n) {
            int diff = findMax(arr) - findMin(arr);
            return diff;
        }
        int mainTemp = arr[currentIndex];
        int temp = arr[currentIndex];
        arr[currentIndex] = arr[currentIndex] + k;
        int val1 = getMinDiffRec(arr, n, k, currentIndex + 1);
        arr[currentIndex] = temp;
        temp = temp - k;
        int val2 = Integer.MAX_VALUE;
        if (temp > 0) {
            arr[currentIndex] = temp;
            val2 = getMinDiffRec(arr, n, k, currentIndex + 1);
        }
        arr[currentIndex] = mainTemp;
        if (val1 < val2)
            return val1;
        else
            return val2;

    }

    private int findMin(int[] arr) {
        int min = arr[0];
        for (int index = 1; index < arr.length; index++) {
            if (arr[index] < min)
                min = arr[index];
        }
        return min;
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int index = 1; index < arr.length; index++) {
            if (arr[index] > max)
                max = arr[index];
        }
        return max;
    }
}
