package com.dsa.app.final450.Arrays;

public class _10_B_LongestTurbulentSubArray {
    public static void main(String[] args) {
        _10_B_LongestTurbulentSubArray obj = new _10_B_LongestTurbulentSubArray();
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        obj.maxTurbulenceSize(arr);
    }

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1)
            return 1;

        int prevNumber = arr[0];
        int tempIndex = 1;

        int flips = 1;
        int maxFlips = 1;

        while (prevNumber == arr[tempIndex]) {
            tempIndex++;
        }

        if (tempIndex == arr.length - 1)
            return 1;

        flips++;
        boolean currentShouldBeGreater = prevNumber > arr[tempIndex] ? false : true;

        tempIndex += 1;
        prevNumber = arr[tempIndex];

        while (tempIndex <= arr.length - 1) {
            if (arr[tempIndex] > prevNumber && currentShouldBeGreater) {
                currentShouldBeGreater = false;
                prevNumber = arr[tempIndex];
                tempIndex++;
                flips++;
            } else if (arr[tempIndex] < prevNumber && !currentShouldBeGreater) {
                currentShouldBeGreater = true;
                prevNumber = arr[tempIndex];
                tempIndex++;
                flips++;
            } else {
                flips = 1;
                prevNumber = arr[tempIndex];
                tempIndex++;
                continue;
            }

            if (flips > maxFlips) {
                maxFlips = flips;

            }
        }
        return maxFlips;
    }
}
