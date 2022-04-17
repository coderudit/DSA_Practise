package com.dsa.app.final450.Arrays;

import java.util.Arrays;

public class _25_TripletSum {
    public static void main(String[] args) {
        _25_TripletSum obj = new _25_TripletSum();
        int[] arr = {1, 4, 45, 6, 10, 8};
        System.out.println(obj.find3Numbers(arr, 21));
    }

    private boolean find3Numbers(int arr[], int sum) {
        int tempVal;
        Arrays.sort(arr);
        for (int eleIndex = 0; eleIndex < arr.length; eleIndex++) {
            tempVal = sum - arr[eleIndex];
            int start = eleIndex + 1;
            int end = arr.length - 1;
            while (start < end) {
                int currentValue = arr[start] + arr[end];
                if (currentValue == tempVal)
                    return true;
                else if (currentValue < tempVal) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return false;
    }

}
