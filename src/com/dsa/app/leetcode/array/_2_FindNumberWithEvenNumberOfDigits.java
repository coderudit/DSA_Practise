package com.dsa.app.leetcode.array;

public class _2_FindNumberWithEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] arr = {555, 901, 482, 1771};
        _2_FindNumberWithEvenNumberOfDigits obj = new _2_FindNumberWithEvenNumberOfDigits();
        System.out.println(obj.findNumbers(arr));
    }

    /*
    * https://www.quora.com/What-is-the-number-of-digits-in-2-2009#:~:text=1000%20and%2010000.-,Notice%20that%201000%20%3D%2010%5E3%20and%20has%204%20digits%2C,10000%2C%20for%20example%2C%205481.
    * */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            //if(String.valueOf(nums[index]).length() %2 == 0)
            if (((int) Math.log10(nums[index]) + 1) % 2 == 0) {
                count++;
            }

        }
        return count;
    }
}
