package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _4_PowerLogarithmic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int power = scanner.nextInt();
        System.out.println("Result: " + logarithmicPower(number, power));
    }

    private static int logarithmicPower(int number, int power) {
        if (power <= 1) {
            return number;
        }
        int result = logarithmicPower(number, (int) power / 2);
        result = result * result;
        if (power % 2 != 0)
            result = result * number;
        return result;
    }
}
