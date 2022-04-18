package com.dsa.app.level1.dynamicprogramming;

public class _1_Fibonacci {

    public static void main(String[] args) {
        int num = 20;
        System.out.println(findFibonacciIterative(num));
        //int[] fibArr = new int[num + 1];
        //int fib = findFibonacci(num, fibArr);
        //System.out.println(fib);
    }

    private static int findFibonacci(int num, int[] fibArr) {
        if (fibArr[num] != -1)
            return fibArr[num];
        int fib1 = findFibonacci(num - 1, fibArr);
        int fib2 = findFibonacci(num - 2, fibArr);
        fibArr[num] = fib1 + fib2;

        return fib1 + fib2;
    }

    private static int findFibonacciIterative(int num) {
        int[] qb = new int[num + 1];
        qb[1] = 1;
        qb[2] = 1;
        for (int i = 3; i <= num; i++) {
            qb[i] = qb[i - 1] + qb[i - 2];
        }

        return qb[num];
    }
}
