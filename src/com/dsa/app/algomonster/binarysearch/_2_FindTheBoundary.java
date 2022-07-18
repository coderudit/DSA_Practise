package com.dsa.app.algomonster.binarysearch;

public class _2_FindTheBoundary {
    public static void main(String[] args) {
        _2_FindTheBoundary problem = new _2_FindTheBoundary();
        boolean[] arr = {false, false, false, false, true};
        System.out.println(problem.findBoundary(arr));
    }

    public int findBoundary(boolean[] arr) {
        int low = 0;
        int high = arr.length - 1;

        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid]) { // alternative use boundary index variable and assign mid value to it.
                if (arr[mid - 1] == false)
                    return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
