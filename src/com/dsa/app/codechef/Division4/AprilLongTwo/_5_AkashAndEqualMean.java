package com.dsa.app.codechef.Division4.AprilLongTwo;

import java.util.Scanner;

public class _5_AkashAndEqualMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int input = 0; input < inputs; input++) {
            int personCount = scanner.nextInt();
            int[] personsWeight = new int[personCount];
            double mean = 0;
            for (int index = 0; index < personCount; index++) {
                personsWeight[index] = scanner.nextInt();
                mean += personsWeight[index];
            }
            mean = mean / personCount;

            int count = 0;
            for (int mainPerson = 0; mainPerson < personCount; mainPerson++) {
                for (int secondPerson = mainPerson + 1; secondPerson < personCount; secondPerson++) {
                    int currentMean = (personsWeight[mainPerson] + personsWeight[secondPerson]) / 2;
                    if (currentMean == mean) {
                        count++;
                    } else if (currentMean > mean){
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
