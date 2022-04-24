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
                    } else if (currentMean > mean) {
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private void countGM() {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int input = 0; input < inputs; input++) {
            int numCount = scanner.nextInt();
            int[] nums = new int[numCount];
            int posCount = 0;
            int negCount = 0;
            for (int numIndex = 0; numIndex < numCount; numIndex++) {
                nums[numIndex] = scanner.nextInt();
                if (nums[numIndex] < 0) {
                    negCount++;
                } else {
                    posCount++;
                }
            }
            int diff = Math.abs(posCount - negCount);
            if (diff == 0) {
                System.out.println("Yes");
            } else if (diff == 1) {
                System.out.println("Yes");
            } else if (diff == 2) {
                if(posCount %2==0 && negCount %2==0) {
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }
}
