package com.dsa.app.codechef.Division4.AprilLongTwo;

import java.util.Scanner;

public class _1_SixFriends {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputs = scanner.nextInt();
        for (int input = 0; input < inputs; input++) {
            int x= scanner.nextInt();
            int y= scanner.nextInt();
            int costX= x * 3;
            int costY = y*2;
            if( costX> costY){
                System.out.println(costY);
            }else{
                System.out.println(costX);
            }
        }
    }

}
