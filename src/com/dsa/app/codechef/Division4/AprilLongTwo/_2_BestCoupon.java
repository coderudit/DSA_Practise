package com.dsa.app.codechef.Division4.AprilLongTwo;

import java.util.Scanner;

public class _2_BestCoupon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int input = 0; input < inputs; input++) {
            int bill = scanner.nextInt();
            double bill10 = bill * 0.10;
            double bill100 = 100;
            if (bill10 > bill100) {
                System.out.println((int)bill10);
            } else {
                System.out.println(100);
            }
        }
    }
}
