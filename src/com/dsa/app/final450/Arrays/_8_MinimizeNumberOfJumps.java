package com.dsa.app.final450.Arrays;

public class _8_MinimizeNumberOfJumps {
    public static void main(String[] args) {
        _8_MinimizeNumberOfJumps obj = new _8_MinimizeNumberOfJumps();
        int[] arr = {1, 4, 3, 2, 6, 7};
        System.out.println(obj.minJumps(arr));
    }

    int minJumps(int[] arr) {
        return minJumpsRec(arr, 0, 0);
    }

    int minJumpsRec(int[] arr, int currentIndex, int totalJumps) {
        if (currentIndex >= arr.length - 1) {
            return totalJumps;
        }

        return minJumpsRec(arr, currentIndex + arr[currentIndex], totalJumps + 1);
    }
}
