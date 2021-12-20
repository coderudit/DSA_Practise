package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _1_PrintDecreasingAndIncreasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println("Printing in decreasing order.");
        printDecreasing(number);

        System.out.println("Printing in increasing order.");
        printIncreasing(number);

        System.out.println("Printing in decreasing and increasing order.");
        printDecreasingAndIncreasing(number);
    }

    private static void printDecreasing(int number) {
        if (number <= 0)
            return;
        System.out.println(number);
        printDecreasing(number - 1);
    }

    private static void printIncreasing(int number) {
        if (number <= 0)
            return;
        printIncreasing(number - 1);
        System.out.println(number);
    }

    private static void printDecreasingAndIncreasing(int number) {
        if (number <= 0)
            return;

        System.out.println(number);
        printDecreasingAndIncreasing(number - 1);
        System.out.println(number);
    }

}
