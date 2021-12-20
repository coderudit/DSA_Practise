package com.dsa.app.level1.gettingstarted;

public class _2_binary_to_decimal {
    public static int convertAnyBaseToDecimal(int number, int currentBase, int requiredBase) {
        int newNumber = 0;
        int index = 0;
        while (number > 0) {
            newNumber += (int) ((number % requiredBase) * Math.pow(currentBase, index));
            number = number / requiredBase;
            index++;
        }
        return newNumber;
    }
}
