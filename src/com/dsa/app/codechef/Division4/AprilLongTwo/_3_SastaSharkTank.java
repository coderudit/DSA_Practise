package com.dsa.app.codechef.Division4.AprilLongTwo;

import java.util.Scanner;

public class _3_SastaSharkTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int input = 0; input < inputs; input++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            first = first * 10;
            second = second * 5;

            if (first == second) {
                System.out.println("ANY");
            } else if (first > second) {
                System.out.println("FIRST");
            } else {
                System.out.println("SECOND");
            }
        }
    }
}
