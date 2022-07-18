package com.dsa.app.algomonster.binarysearch;

public class _1_BinarySearch {
    public static void main(String[] args) {
        _1_BinarySearch problem = new _1_BinarySearch();
        int[] arr = {5, 15, 25, 35, 45, 65};
        int key = 15;
        problem.binarySearch(arr, key);

    }

    public boolean binarySearch(int[] arr, int key) {
        if (arr == null || arr.length == 0 || key < arr[0] || key > arr[arr.length - 1])
            return false;

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return true;
            else if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return false;
    }
}
