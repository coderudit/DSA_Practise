package com.dsa.app.leetcode.dynamicprogramming;

public class _1137_tribonacciNumber {
    public static void main(String[] args) {

        int n = 25;
        int[] tribonacciNumberArr = new int[n + 1];
        tribonacciNumberArr[0] = 0;
        tribonacciNumberArr[1] = 1;
        tribonacciNumberArr[2] = 1;
        int numResult = tribonacci(n, tribonacciNumberArr);
        System.out.println(numResult);
    }

    private static int tribonacci(int n, int[] tribonacciNumberArr) {
        if (n < 0)
            return 0;
        if (tribonacciNumberArr[n] != 0)
            return tribonacciNumberArr[n];

        int num1 = tribonacci(n - 1, tribonacciNumberArr);
        int num2 = tribonacci(n - 2, tribonacciNumberArr);
        int num3 = tribonacci(n - 3, tribonacciNumberArr);
        tribonacciNumberArr[n] = num1 + num2 + num3;
        return tribonacciNumberArr[n];
    }
}
