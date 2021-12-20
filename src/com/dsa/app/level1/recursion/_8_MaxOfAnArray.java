package com.dsa.app.level1.recursion;

public class _8_MaxOfAnArray {
    public static void main(String[] args) {
        int[] arr = {45, 42, 65, 16, 19};
        System.out.println("Max: " + max(arr, 0));
    }

    private static int max(int[] arr, int index) {
        if (index == arr.length)
            return -1;
        int result = max(arr, index + 1);
        if (result > arr[index])
            return result;
        else
            return arr[index];
    }
}
