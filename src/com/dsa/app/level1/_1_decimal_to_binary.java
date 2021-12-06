package com.dsa.app.level1;

public class _1_decimal_to_binary {

    public static int convertDecimalToAnyBase(int number, int requiredBase) {
        StringBuilder newNumber = new StringBuilder();
        while(number > 0){
            newNumber.append(number % requiredBase);
            number = number/requiredBase;
        }
        return Integer.parseInt(String.valueOf(newNumber.reverse()));
    }
}
