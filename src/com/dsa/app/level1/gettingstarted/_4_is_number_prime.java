package com.dsa.app.level1.gettingstarted;

import java.util.Scanner;

public class _4_is_number_prime {

    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int numsCount = scanner.nextInt();
    for(int index = 0; index < numsCount; index++){
        int num = scanner.nextInt();
    }
    }

    public static String isNumberPrime(int number) {
        if (number <= 1)
            return "Not Prime";
        for (int index = 2; index < number; index++) {
            if (number % index == 0)
                return "Not Prime";
        }
        return "Prime";
    }

    public static String isNumberPrimeSqrt(int number) {
        if (number <= 1)
            return "Not Prime";
        for (int index = 2; index *index <= number; index++) {
            if (number % index == 0)
                return "Not Prime";
        }
        return "Prime";
    }

    public static String isNumberPrimeSqrtOptimized(int number) {
        if (number <= 1)
            return "Not Prime";
        else if (number == 2)
            return "Prime";
        else if (number % 2 == 0) {
            assert (number > 2);
            return "Not Prime";
        }
        for (int index = 3; index <= Math.sqrt(number); index++) {
            if (number % index == 0)
                return "Not Prime";
        }
        return "Prime";
    }

    public static void sieveMethodForGettingListOfPrimes(int number){

    }
}
