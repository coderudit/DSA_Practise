package com.dsa.app.level1.dynamicprogramming._3_IncludeExclude;

import java.util.Scanner;

public class _15_CountSubsequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            if (ch == 'a') {
                a = 2 * a + 1;
            } else if (ch == 'b') {
                ab = 2 * ab + a;
            } else if (ch == 'c') {
                abc = 2 * abc + ab;
            }
        }
        System.out.println(abc);
    }

}
