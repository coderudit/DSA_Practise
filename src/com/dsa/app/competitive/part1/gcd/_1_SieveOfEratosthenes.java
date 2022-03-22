package com.dsa.app.competitive.part1.gcd;

import java.util.Arrays;

public class _1_SieveOfEratosthenes {
    public static void main(String[] args) {
        _1_SieveOfEratosthenes obj = new _1_SieveOfEratosthenes();
        obj.sieveOfEratosthenes(1000);
    }

    public void sieveOfEratosthenes(int n) {

        boolean primeNumbers[] = new boolean[n + 1];
        Arrays.fill(primeNumbers, true);

        int loopRanCount = 1;
        for (int number = 2; number * number <= n; number++) {

            // Start marking multiples of this false only when this number is itself prime,
            // if it's not prime this number and it's multiples would have been marked false.
            if (primeNumbers[number] == true) {
                for (int currentNumber = number * number; currentNumber <= n; currentNumber += number) {
                    primeNumbers[currentNumber] = false;
                    System.out.println(loopRanCount++);
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (primeNumbers[i] == true)
                System.out.print(i + " ");
        }
    }
}
