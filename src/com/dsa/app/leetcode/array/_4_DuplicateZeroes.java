package com.dsa.app.leetcode.array;

public class _4_DuplicateZeroes {
    public static void main(String[] args) {
        _4_DuplicateZeroes obj = new _4_DuplicateZeroes();
        int[] arr = {0, 0, 0, 0, 0, 0, 0};
        obj.duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {
        int count = 0;

        int length = arr.length - 1;

        //Possible duplicates
        for (int index = 0; index <= length - count; index++) {
            if (arr[index] == 0) {
                //Edge case: When 0 is at the end.
                if (index == length - count) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                count++;
            }
        }


        int last = length - count;

        for (int index = last; index >= 0; index--) {
            if (arr[index] == 0) {
                arr[index + count] = 0;
                count--;
                arr[index + count] = 0;
            } else {
                arr[index + count] = arr[index];
            }

        }
    }

}
