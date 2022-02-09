package com.dsa.app.competitive.part1.gcd;

public class euclidean_algorithm {
    public static void main(String[] args) {
        euclidean_algorithm obj = new euclidean_algorithm();
        //System.out.println(obj.gcd(10, 45));
        //System.out.println(obj.gcd(1, 5));
        System.out.println(obj.gcd(1701, 3768));
        //System.out.println(obj.gcd(10, 45));
        //System.out.println(obj.gcd(10, 45));
    }

    /**
     * Take the highest of 2 numbers, find the remainder with other number and then, again repeat it where this time other number is divided by the remainder.
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}
