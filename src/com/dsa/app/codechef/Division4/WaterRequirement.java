package com.dsa.app.codechef.Division4;

import java.util.Scanner;

public class WaterRequirement {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int index=0; index<num; index++){
            System.out.println(scanner.nextInt()*2);
        }
    }
}
