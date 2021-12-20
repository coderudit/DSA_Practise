package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _6_TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        towerOfHanoi(number, "A", "B", "C");
    }

    private static void towerOfHanoi(int diskNumber, String from, String to, String using) {
        if (diskNumber <= 0)
            return;
        towerOfHanoi(diskNumber - 1, from, using, to);
        System.out.println("Moving disk " + diskNumber + " from " + from + " to " + to +
                " using " + using);
        towerOfHanoi(diskNumber - 1, using, to, from);
    }
}
