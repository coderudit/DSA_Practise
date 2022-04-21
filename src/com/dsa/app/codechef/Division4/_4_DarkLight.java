package com.dsa.app.codechef.Division4;

import java.util.Scanner;

public class _4_DarkLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int index = 0; index < num; index++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(new _4_DarkLight().getState(n, k));
        }
    }

    private String getState(int n, int k) {
        if (k == 0) {
            if (n == 0 || n % 4 == 0)
                return "Off";
            return "On";
        } else {
            if (n == 0 || n % 4 == 0)
                return "On";
            return "Ambiguous";
        }
    }
}
