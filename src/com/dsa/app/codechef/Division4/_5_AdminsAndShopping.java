package com.dsa.app.codechef.Division4;

import java.util.Scanner;

public class _5_AdminsAndShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int index = 0; index < num; index++) {
            int shops = scanner.nextInt();
            int admins = scanner.nextInt();
            int[] capacity = new int[shops];
            for (int shop = 0; shop < shops; shop++) {
                capacity[shop] = scanner.nextInt();
            }
            System.out.println(new _5_AdminsAndShopping().getHours(admins, capacity));
        }
    }

    private int getHours(int admins, int[] capacity) {
        int count = 0;
        int prevBuffer = 0;
        for (int shopIndex = 0; shopIndex < capacity.length; shopIndex++) {
            if (capacity[shopIndex] == admins) {
                count+=1;
            }else if(capacity[shopIndex] < admins){
                prevBuffer = admins-capacity[shopIndex];
                count+=1;
            }else {
                prevBuffer = prevBuffer + admins-capacity[shopIndex];
                count+=1;
            }
        }
        count += prevBuffer/capacity[capacity.length-1];
        return count;
    }

}
