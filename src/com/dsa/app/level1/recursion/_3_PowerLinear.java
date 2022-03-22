package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _3_PowerLinear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int power = scanner.nextInt();
        System.out.println("Result: " + powerLinear(number, power));
    }

    private static int powerLinear(int number, int power) {
        if (power == 0)
            return 1;
        if (power == 1)
            return number;
        int result = powerLinear(number, power-1);
        return result * number;
    }
}
