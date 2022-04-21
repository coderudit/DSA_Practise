package com.dsa.app.codechef.Division4;

import java.util.Scanner;

public class _2_PoliceAndThief {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int index = 0; index < num; index++) {
            int police = scanner.nextInt();
            int thief = scanner.nextInt();
            if (police > thief)
                System.out.println(new _2_PoliceAndThief().catchThief(thief, police));
            else
                System.out.println(new _2_PoliceAndThief().catchThief(police, thief));
        }
    }

    private int catchThief(int police, int thief) {

        int count = 0;
        while (police != thief) {
            police += 2;
            thief += 1;
            count++;
        }
        return count;
    }

}
