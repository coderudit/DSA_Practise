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
     * Take the highest of 2 numbers, find the remainder with other number and then, again repeat it where this time other number is divided by the remainder.
     * It takes O(log(min(a,b))
     *
     * @param a
     * @param b
     * @return
     */
    public int binary_gcd(int a, int b) {
        if (a == b)
            return a;

        if (a == 0)
            return b;

        if (b == 0)
            return a;

        //If a is divisible by 2.
        if ((a & 1) == 0) {
            // both a and b are even
            if ((b & 1) == 0) {
                return gcd(a >> 1, b >> 1) << 1;
            } else {// b is odd
                return gcd(a >> 1, b);
            }
        }

        // a is odd, b is even
        if ((b & 1) == 0)
            return gcd(a, b >> 1);

        //It will come here when both a and b are odd. Subtracting 2 odd numbers will give even number.
        if (a > b)
            return gcd((a - b) >> 1, b);

        return gcd((b - a) >> 1, a);
    }

    /**
     * LCM of 2 numbers is least number that is divisible by both the numbers. For this, find the GCD of these 2 numbers and
     * divide a * b with GCD to get the LCM.
     *
     * @param a
     * @param b
     * @return
     */
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
