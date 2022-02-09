package com.dsa.app.competitive.part1.gcd;

public class euclidean_algorithm {
    public static void main(String[] args) {
        euclidean_algorithm obj = new euclidean_algorithm();
        //System.out.println(obj.gcd(10, 45));
        //System.out.println(obj.gcd(1, 5));
        System.out.println("GCD: " + obj.gcd(1701, 3768));
        //System.out.println(obj.gcd(10, 45));
        //System.out.println(obj.gcd(10, 45));

        System.out.println("LCM: " + obj.lcm(1701, 3768));
    }

    /**
     * Take the highest of 2 numbers, find the remainder with other number and then, again repeat it where this time other number is divided by the remainder.
     * It takes O(log(min(a,b))
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

    /**
     * LCM of 2 numbers is least number that is divisible by both the numbers. For this, find the GCD of these 2 numbers and
     * divide a * b with GCD to get the LCM.
     * @param a
     * @param b
     * @return
     */
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
