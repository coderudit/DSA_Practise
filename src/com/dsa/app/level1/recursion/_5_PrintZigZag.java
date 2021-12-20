package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _5_PrintZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        zigZag(number);
    }
    private static void zigZag(int number){
        if(number <=0 )
            return;
        System.out.println("Pre: "+ number);
        zigZag(number-1);
        System.out.println("In: "+ number);
        zigZag(number-1);
        System.out.println("Post: "+ number);
    }
}
