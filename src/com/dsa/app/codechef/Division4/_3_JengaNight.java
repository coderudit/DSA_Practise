package com.dsa.app.codechef.Division4;

import java.util.Scanner;

public class _3_JengaNight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int index = 0; index < num; index++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            System.out.println(new _3_JengaNight().playJenga(n, x));
        }
    }

    private boolean playJenga(int n, int x){
        if(x%n>0)
            return false;
        return true;
    }
}
