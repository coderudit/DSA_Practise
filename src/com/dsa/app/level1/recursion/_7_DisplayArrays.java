package com.dsa.app.level1.recursion;

public class _7_DisplayArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        displayArray(arr, 0);
        displayReverseArray(arr, 0);
    }

    private static void displayArray(int[] arr, int index) {
        if (index == arr.length)
            return;
        System.out.println(arr[index]);
        displayArray(arr, index + 1);
    }

    private static void displayReverseArray(int[] arr, int index){
        if(index== arr.length)
            return;
        displayReverseArray(arr, index+1);
        System.out.println(arr[index]);
    }
}
