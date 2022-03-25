package com.dsa.app.level1.dynamicprogramming;

public class _3_NumberOfStairCasePathWithJumps {
    public static void main(String[] args) {
        int num = 10;
        int[] varPathsArr = new int[num + 1];
        int numberOfPaths = countPaths(varPathsArr, 0, num);
        System.out.println(numberOfPaths);
        int numberOfPaths2 = countNumberOfPathsWithMemoization(num, varPathsArr);
        System.out.println(numberOfPaths2);

        varPathsArr = new int[num + 1];
        int numberOfPaths3 = countNumberOfPathsUpdated(num, varPathsArr);
        System.out.println(numberOfPaths3);
    }

    private static int countPaths(int[] arr, int index, int len) {
        if (index == len) {
            return 1;
        }
        int count = 0;
        for (int jump = 1; jump <= arr[index]; jump++) {
            if ((jump + index) <= len) {
                count += countPaths(arr, jump + index, len);
            } else {
                break;
            }
        }
        return count;
    }

    private static int countNumberOfPathsWithMemoization(int num, int[] varPathsArr) {
        if (num == 0)
            return 1;
        else if (num < 0)
            return 0;

        int numberOfPaths = 0;
        for (int index = 1; index <= num; index++) {
            if (varPathsArr[num - index] == 0) {
                numberOfPaths += countNumberOfPathsWithMemoization(num - index, varPathsArr);
            }
        }
        return numberOfPaths;
    }

    private static int countNumberOfPathsUpdated(int num, int[] varPathsArr) {
        if (num == 1)
            return 1;
        if (num < 1)
            return 1;

        if (varPathsArr[num] > 0)
            return varPathsArr[num];

        int paths = 0;
        for (int i = num - 1; i >= 0; i--) {
            paths += countNumberOfPathsUpdated(i, varPathsArr);
        }
        varPathsArr[num] = paths;
        return varPathsArr[num];
    }
}
