package com.dsa.app.leetcode;

import java.util.Arrays;

public class _6000_sortevenandodd {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2, 3};
        int[] nums2 = {1, 2};
        int[] nums3 = {36, 45, 32, 31, 15, 41, 9, 46, 36, 6, 15, 16, 33, 26, 27, 31, 44, 34};
        _6000_sortevenandodd obj = new _6000_sortevenandodd();
        obj.sortEvenOdd(nums3);
    }

    public int[] sortEvenOdd(int[] nums) {
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        int[] newArr = new int[nums.length];

        int prevIndex = 1;
        int currentIndex = 0;
        while (currentIndex < nums.length - 1) {
            if (nums[prevIndex - 1] == nums[prevIndex]) {
                prevIndex = prevIndex - 1;

                while (nums[prevIndex] == nums[prevIndex + 1]) {
                    newArr[currentIndex] = nums[prevIndex];
                    currentIndex += 2;
                    prevIndex++;
                }
                newArr[currentIndex] = nums[prevIndex];
                currentIndex += 2;
                prevIndex += 2;
            } else {
                newArr[currentIndex] = nums[prevIndex];
                currentIndex += 2;
                prevIndex += 2;
            }
        }

        prevIndex = nums.length - 2;
        currentIndex = 1;
        while (currentIndex < nums.length) {
            newArr[currentIndex] = nums[prevIndex];
            currentIndex += 2;
            prevIndex -= 2;
        }

        return newArr;
    }

    public int[] sortEvenOdd3(int[] nums) {
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        int[] newArr = new int[nums.length];

        int newIndex = 0;
        for (int index = 1; index < nums.length - 1 && newIndex < nums.length; ) {
            if (nums[index - 1] == nums[index]) {
                while (nums[index - 1] == nums[index]) {
                    newArr[newIndex] = nums[index];
                    newArr[newIndex + 2] = nums[index];
                    nums[index - 1] = -1;
                    nums[index] = -1;
                    newIndex += 2;
                    index++;
                }
                newIndex += 2;
                index++;
            } else if (nums[index] == nums[index + 1]) {
                while (nums[index] == nums[index + 1]) {
                    newArr[newIndex] = nums[index];
                    newArr[newIndex + 2] = nums[index];
                    nums[index] = -1;
                    nums[index + 1] = -1;
                    newIndex += 2;
                    index++;
                }
                newIndex += 2;
                index += 2;
            } else {
                newArr[newIndex] = nums[index];
                nums[index] = -1;
                newIndex += 2;
                index += 2;
            }
        }
        newIndex -= 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            if (nums[index] != -1) {
                newArr[newIndex] = nums[index];
                newIndex -= 2;
            }
        }
        return newArr;
    }


    public int[] sortEvenOdd2(int[] nums) {
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        int[] newArr = new int[nums.length];

        int prevIndex = 1;
        int currenIndex = 0;
        newArr[currenIndex] = nums[prevIndex];
        currenIndex += 2;
        prevIndex += 2;
        while (prevIndex < nums.length && currenIndex < nums.length - 1) {
            if (nums[prevIndex - 1] == nums[prevIndex]) {
                newArr[currenIndex] = nums[prevIndex - 1];
                currenIndex += 2;
                newArr[currenIndex] = nums[prevIndex];
            } else if (nums[prevIndex] == nums[prevIndex + 1]) {
                newArr[currenIndex] = nums[prevIndex];
                currenIndex += 2;
                newArr[currenIndex] = nums[prevIndex + 1];
                prevIndex = prevIndex + 1;
            } else {
                newArr[currenIndex] = nums[prevIndex];
            }
            currenIndex += 2;
            prevIndex += 2;
        }

        prevIndex = nums.length - 1;
        currenIndex = 1;
        newArr[currenIndex] = nums[prevIndex];
        currenIndex += 2;
        prevIndex -= 2;
        while (currenIndex < nums.length) {
            if (nums[prevIndex - 1] == nums[prevIndex]) {
                //newArr[currenIndex] = nums[prevIndex - 1];
                currenIndex += 2;
                //newArr[currenIndex] = nums[prevIndex];
            } else if (nums[prevIndex] == nums[prevIndex + 1]) {
                //newArr[currenIndex] = nums[prevIndex];
                currenIndex += 2;
                //newArr[currenIndex] = nums[prevIndex + 1];
                prevIndex = prevIndex - 1;
            } else {
                newArr[currenIndex] = nums[prevIndex];
            }
            currenIndex += 2;
            prevIndex -= 2;
        }

        return newArr;
    }
}
