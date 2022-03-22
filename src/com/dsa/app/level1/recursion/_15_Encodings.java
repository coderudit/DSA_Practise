package com.dsa.app.level1.recursion;

import java.util.HashMap;
import java.util.Map;

public class _15_Encodings {
    private static Map<String, String> encodings;

    public static void main(String[] args) {
        encodings = new HashMap<>();
        for (int index = 0; index <= 25; index++) {
            encodings.put(String.valueOf(index + 1), new Character((char) ((char) 97 + index)).toString());
        }
        printEncodings("123", "", 0);
    }

    private static void printEncodings(String str, String value, int currentIndex) {
        if (str.length() == 0) {
            System.out.println(value);
            return;
        }

        //for (int index = currentIndex; index < str.length(); index++) {
        printEncodings(str.substring(1),
                value + encodings.get(String.valueOf(str.charAt(0))),
                currentIndex + 1);
        int firstValue = str.charAt(0) -'0';
        if (firstValue <= 2 && str.length() >= 2) {
            int secondValue = str.charAt(1) - '0';
            if (secondValue <= 6)
                printEncodings(str.substring(2),
                        encodings.get(str.substring(0, 2)),
                        1);
        }
        // }
    }
}
