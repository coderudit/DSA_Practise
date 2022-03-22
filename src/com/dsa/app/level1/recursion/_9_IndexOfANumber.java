package com.dsa.app.level1.recursion;

public class _9_IndexOfANumber {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 3, 4, 2, 4};
        System.out.println("First index: " + firstIndex(arr, 0, 4));
        System.out.println("Last index: " + lastIndex(arr, 0, 4));
        int[] indicesArray = allIndicesOfAnArray(arr, 0, 4, 0);
        for (int index = 0; index < indicesArray.length; index++) {
            System.out.println("Index " + indicesArray[index]);
        }
    }

    private static int firstIndex(int[] arr, int index, int number) {
        if (index == arr.length)
            return -1;
        if (arr[index] == number)
            return index + 1;
        return firstIndex(arr, index + 1, number);
    }

    private static int lastIndex(int[] arr, int index, int number) {
        if (index == arr.length)
            return -1;
        int foundIndex = lastIndex(arr, index + 1, number);
        if (foundIndex != -1)
            return foundIndex;
        if (arr[index] == number)
            return index + 1;
        else
            return foundIndex;
    }

    private static int[] allIndicesOfAnArray(int[] arr, int index, int number, int count) {
        if (index == arr.length)
            return new int[count + 1];
        int currentIndex = -1;
        if (arr[index] == number) {
            currentIndex = index + 1;
            count = count + 1;
        }
        int[] newArr = allIndicesOfAnArray(arr, index + 1, number, count);
        if (currentIndex != -1) {
            newArr[count] = currentIndex;
        }
        return newArr;
    }
}
