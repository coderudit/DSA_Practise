package com.dsa.app.level1.gettingstarted;

public class _4_is_number_prime {

    public static boolean isNumberPrime(int number) {
        if (number <= 1)
            return false;
        for (int index = 2; index < number; index++) {
            if (number % index == 0)
                return false;
        }
        return true;
    }

    public static boolean isNumberPrimeSqrt(int number) {
        if (number <= 1)
            return false;
        for (int index = 2; index <= Math.sqrt(number); index++) {
            if (number % index == 0)
                return false;
        }
        return true;
    }

    public static boolean isNumberPrimeSqrtOptimized(int number) {
        if (number <= 1)
            return false;
        else if (number == 2)
            return true;
        else if (number % 2 == 0) {
            assert (number > 2);
            return false;
        }
        for (int index = 3; index <= Math.sqrt(number); index++) {
            if (number % index == 0)
                return false;
        }
        return true;
    }

    public static void sieveMethodForGettingListOfPrimes(int number){

    }
}
