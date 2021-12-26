package com.dsa.app.level1.dynamicprogramming;

public class _1_Fibonacci {

    public static void main(String[] args) {
        int num = 5;
        int[] fibArr = new int[num+1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for(int index = 2; index<= num; index++){
            fibArr[index] = -1;
        }
        int fib = findFibonacci(num, fibArr);
        System.out.println(fib);
    }

    private static int findFibonacci(int num, int[] fibArr){
        if(fibArr[num] != -1)
            return fibArr[num];
        int fib1 = findFibonacci(num-1, fibArr);
        int fib2 = findFibonacci(num-2, fibArr);
            fibArr[num] = fib1+ fib2;

        return fib1+ fib2;
    }
}
