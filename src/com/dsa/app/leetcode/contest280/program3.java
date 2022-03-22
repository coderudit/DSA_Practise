package com.dsa.app.leetcode.contest280;

import java.util.Arrays;
import java.util.Comparator;

public class program3 {
    public static void main(String[] args) {
        program3 obj = new program3();
        int[] beans0= {4, 1, 6, 5};
        int[] beans1 = {2, 10, 3, 2};
        int[] beans2 = {60};
        int[] beans3 = {-1};
        System.out.println(obj.minimumRemoval2(beans0));
    }

    public long minimumRemoval2(int[] beans) {
        Arrays.sort(beans);
        long count = Long.MAX_VALUE;
        for (int row = 0; row < beans.length; row++) {
            long innerCount = 0;
            int index = 0;
            while(index < row) {
                innerCount += beans[index];
                index++;
            }
            for (int column = row + 1; column < beans.length; column++) {
                innerCount += (beans[column] - beans[row]);
            }

            if (innerCount < count) ;
            count = innerCount;
            innerCount = 0;
        }
        return count;
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long count = 0;
        long prevSum = beans[0];
        for (int index = 1; index < beans.length; index++) {
            count += beans[index] - prevSum;
            prevSum = beans[index];
        }
        return count == 0 ? 0 : count - 1;
    }
}
