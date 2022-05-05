package com.dsa.app.leetcode.contest291;

public class Program1 {
    public static void main(String[] args) {
        Program1 program = new Program1();
        String number = "133235";
        String number2 = "11111";
        String number3 = "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        char digit = '1';
        System.out.println(program.removeDigitNew(number2, digit));
    }

    public String removeDigitNew(String number, char digit) {
        int firstFind = number.indexOf(digit);
        String newString1 = number.substring(0, firstFind) + number.substring(firstFind + 1);
        int secondFind = number.substring(firstFind + 1).indexOf(digit);
        if (secondFind == -1)
            return newString1;
        secondFind = secondFind + number.substring(0, firstFind).length() + 1;
        String max = newString1;
        String maxString = newString1;

        while (secondFind != -1) {
            String newString2 = number.substring(0, secondFind) + number.substring(secondFind + 1);
            if (max.compareTo(newString2) < 0) {
                max = newString2;
                maxString = newString2;
            }
            firstFind = secondFind;
            secondFind = number.substring(secondFind + 1).indexOf(digit);
            if (secondFind != -1)
                secondFind = secondFind + number.substring(0, firstFind).length() + 1;
        }
        return maxString;
    }

    public String removeDigit(String number, char digit) {
        int firstFind = number.indexOf(digit);
        String newString1 = number.substring(0, firstFind) + number.substring(firstFind + 1);
        int secondFind = number.substring(firstFind + 1).indexOf(digit);
        if (secondFind == -1)
            return newString1;
        secondFind = secondFind + number.substring(0, firstFind).length() + 1;
        int max = Integer.parseInt(newString1);
        String maxString = newString1;
        while (secondFind != -1) {
            String newString2 = number.substring(0, secondFind) + number.substring(secondFind + 1);
            if (max < Integer.parseInt(newString2)) {
                max = Integer.parseInt(newString2);
                maxString = newString2;
            }
            firstFind = secondFind;
            secondFind = number.substring(secondFind + 1).indexOf(digit);
            if (secondFind != -1)
                secondFind = secondFind + number.substring(0, firstFind).length() + 1;
        }
        return maxString;
    }
}
