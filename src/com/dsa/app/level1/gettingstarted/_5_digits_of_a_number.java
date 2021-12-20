package com.dsa.app.level1.gettingstarted;

public class _5_digits_of_a_number {
    private static int digitsCount(int number) {
        int digits = 0;
        while (number > 0) {
            number = number / 10;
            digits++;
        }
        return digits;
    }


    public static void printDigitsOfANumber(int number) {
        int countNumber = digitsCount(number);
        int divisor = (int) Math.pow(10, countNumber-1);

        while (divisor != 0) {
            int num = number / divisor;
            System.out.println(num);
            number = number % divisor;
            countNumber--;
            divisor = divisor / 10;
        }
    }
}
