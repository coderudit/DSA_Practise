package com.dsa.app.leetcode.contest285;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        String direction1 = "RLRSLL";
        String direction2 = "LLRR";
        String direction3 = "LLSRSSRSSLLSLLLRSLSRL";
        String direction4 = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        String direction5 = "SRRLRLRSRLRSSRRLSLRLLRSLSLLSSRRLSRSLSLRRS";
        System.out.println(obj.countCollisions(direction4));
    }

    public int countCollisions(String directions) {
        char[] arrDirections = directions.toCharArray();
        if (directions.length() <= 1)
            return 0;

        int collisions = 0;
        char prevDir = arrDirections[0];
        int nRCars = 0;
        for (int index = 1; index < arrDirections.length; index++) {
            if (prevDir == 'R' && arrDirections[index] == 'L') {//RL
                prevDir = 'S';
                if (nRCars > 0) {
                    collisions += 2;
                    collisions += (nRCars);
                    nRCars = 0;
                } else
                    collisions += 2;

            } else if (prevDir == 'S' && arrDirections[index] == 'L') {
                //prevDir = 'S';
                collisions += 1;
            } else if (prevDir == 'R' && arrDirections[index] == 'S') {
                prevDir = 'S';
                if (nRCars > 0) {
                    collisions += nRCars+1;
                    nRCars = 0;
                } else
                    collisions += 1;
            } else if (prevDir == 'R' && arrDirections[index] == 'R') {
                nRCars++;
            } else {
                prevDir = arrDirections[index];
            }
        }
        /*if (nRCars > 0)
            collisions++;*/
        return collisions;
    }

}
