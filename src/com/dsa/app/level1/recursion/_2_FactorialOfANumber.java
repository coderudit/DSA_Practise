package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _2_FactorialOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Factorial of " + number + " is " + factorial(number));
    }

    private static int factorial(int number) {
        if (number <= 1)
            return 1;
        return number * factorial(number-1);
    }
}
