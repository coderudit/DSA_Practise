package com.dsa.app.leetcode.contest281;

public class Program1 {
    public static void main(String[] args) {
        Program1 obj = new Program1();
        System.out.println(obj.countEven(30));
    }

    public int countEven(int num) {
        if (num < 2)
            return 0;
        int numSize = (int) (Math.log10(num) + 1);

        int count = 0;

        if (numSize == 1) {
            for (int index = 2; index <= num; index++) {
                if (index % 2 == 0)
                    count++;
            }
        } else if (numSize == 2) {
            int fourCount = (num / 10) % 2 == 0 ? (num / 10) / 2 : (num / 10) / 2 + 1;
            int fiveCount =(num / 10) % 2 == 0 ? fourCount : fourCount - 1;
            int startValue = (num / 10) * 10;
            for (int index = startValue+1; index <= num; index++) {
                if (fiveCount % 2 == 0) {
                    if (index % 2 == 0)
                        count++;
                } else {
                    if (index % 2 != 0)
                        count++;
                }
            }
            count += 4 * fourCount;
            count += 6 * fiveCount;
        } else if (numSize == 3) {
            int fourCount = (num / 100) % 2 == 0 ? (num / 100) / 2 : (num / 100) / 2 + 1;
            int fiveCount =(num / 100) % 2 == 0 ? fourCount : fourCount - 1;
            int startValue = (num / 10) * 100;
            for (int index = startValue; index <= num; index++) {
                if (fiveCount % 2 == 0) {
                    if (index % 2 == 0)
                        count++;
                } else {
                    if (index % 2 != 0)
                        count++;
                }
            }
            count += 4 * fourCount;
            count += 6 * fiveCount;
        }
        return count;
    }

}
