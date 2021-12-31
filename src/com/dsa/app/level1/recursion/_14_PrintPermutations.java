package com.dsa.app.level1.recursion;

public class _14_PrintPermutations {
    public static void main(String[] args) {
        printPermutations("abc", "");
    }

    private static void printPermutations(String input, String value) {
        if (input == null || input.length() == 0) {
            System.out.println(value);
            return;
        }

        for (int index = 0; index < input.length(); index++) {
            Character chosenChar = input.charAt(index);
            printPermutations(input.substring(0, index) + input.substring(index + 1), value + chosenChar);
        }
    }
}
