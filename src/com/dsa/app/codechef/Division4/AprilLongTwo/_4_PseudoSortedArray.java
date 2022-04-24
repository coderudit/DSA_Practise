package com.dsa.app.codechef.Division4.AprilLongTwo;

import java.util.Scanner;

public class _4_PseudoSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int input = 0; input < inputs; input++) {
            int nums = scanner.nextInt();

            int[] currentNum = new int[nums];
            for (int num = 0; num < nums; num++) {
                currentNum[num] = scanner.nextInt();
            }

            int count = 0;
            for (int num = 1; num < nums; num++) {
                if (currentNum[num] < currentNum[num - 1]) {
                    int temp = currentNum[num];
                    currentNum[num] = currentNum[num - 1];
                    currentNum[num - 1] = temp;
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }

            if (count > 1) {
                System.out.println("NO");
            } else {
                for (int num = 1; num < nums; num++) {
                    if (currentNum[num] < currentNum[num - 1]) {
                        int temp = currentNum[num];
                        currentNum[num] = currentNum[num - 1];
                        currentNum[num - 1] = temp;
                        count++;
                        if (count > 1) {
                            break;
                        }
                    }
                }

                if (count > 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }

    }

    /*private void discarded(){
        int count = 0;
        for (int num = 1; num < nums; num++) {
            if (currentNum[num] < currentNum[num - 1]) {
                int temp = currentNum[num];
                currentNum[num] = currentNum[num - 1];
                currentNum[num - 1] = temp;
                count++;
                if (count > 1) {
                    break;
                }
                int tempNum = num;
                while (tempNum - 1 > 0) {
                    if (currentNum[tempNum] < currentNum[tempNum - 1]) {
                        count++;
                        break;
                    }
                    tempNum--;
                }
                if (count > 1) {
                    break;
                }
            }
        }

        if (count > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }*/
}
