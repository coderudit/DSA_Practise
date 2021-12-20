package com.dsa.app.level1.gettingstarted;

public class _3_anybaseA_to_anybaseB {

    //Converts ASCII value from 0 to 15.
    public static int valueOfChar(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0'; //c='5' => 52 - 47 = 5
        else
            return (int) c - 'A' + 10; //c='B' => 66 - 65 + 10 = 1+10 = 11
    }

    public static int toDecimal(String number, int base) {

        int len = number.length();
        int index = 0;
        int value = 0;

        for (int startIndex = len - 1; startIndex >= 0; startIndex--) {
            if (valueOfChar(number.charAt(startIndex)) > base) {
                return -1;
            }
            value += (int) Math.pow(base, index) * valueOfChar(number.charAt(startIndex));
            index++;
        }

        return value;
    }

    public static String toBase(int number, int base) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.append(number % base);
            number = number / base;
        }
        return result.reverse().toString();
    }

    public static void convertFromBaseAToBaseB(String number, int baseA, int baseB){
        int resultA = toDecimal(number,  baseA);
        String resultB = toBase(resultA, baseB);
        System.out.println(resultB);
    }
}
