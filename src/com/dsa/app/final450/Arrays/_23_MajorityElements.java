package com.dsa.app.final450.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _23_MajorityElements {
    public static void main(String[] args) {
        _23_MajorityElements obj = new _23_MajorityElements();
        int[] elements = {5, 1, 4, 1, 1, 2, 3, 1, 1};
        System.out.println(obj.mooreVotingAlgoWithNby2(elements));
    }

    //Time: O(n*n)
    //Space: O(1)
    private void bruteforce_pickAndCount() {
    }

    //Time: O(nlogn + n)
    //Space: O(1)
    private void bruteforce_sortAndCount() {
    }

    //Time: O(n)
    //Space: O(n)
    private List<Integer> bruteforce_usingMap(int[] nums) {
        List<Integer> lis = new ArrayList();
        Map<Integer, Integer> numsMap = new HashMap();
        for (int index = 0; index < nums.length; index++) {
            if (!numsMap.containsKey(nums[index])) {
                numsMap.put(nums[index], 0);
            }
            numsMap.put(nums[index], numsMap.get(nums[index]) + 1);
        }

        for (var key : numsMap.keySet()) {
            if (numsMap.get(key) > nums.length / 3) {
                lis.add(key);
            }
        }
        return lis;
    }

    //Time: O(n)
    //Space: O(1)
    private int mooreVotingAlgoWithNby2(int[] elements) {
        int count = 1;
        int ansIndex = 0;
        for (int index = 1; index < elements.length; index++) {
            if (elements[index] == elements[ansIndex]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                ansIndex = index;
                count = 1;
            }
        }
        return elements[ansIndex];
    }

    //Time: O(n)
    //Space: O(1)
    private List<Integer> mooreVotingAlgoWithNby3(int[] elements) {

        int count1 = 0;
        int count2 = 0;
        int element1 = -1;
        int element2 = -1;
        for (int index = 0; index < elements.length; index++) {
            if (element1 == elements[index]) {
                count1++;
            } else if (element2 == elements[index]) {
                count2++;
            } else if (count1 == 0) {
                element1 = elements[index];
                count1 = 1;
            } else if (count2 == 0) {
                element2 = elements[index];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> lis = new ArrayList();
        count1 = 0;
        count2 = 0;
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == element1)
                count1++;
            else if (elements[index] == element2)
                count2++;
        }
        if (count1 > elements.length / 3)
            lis.add(element1);
        if (count2 > elements.length / 3)
            lis.add(element2);
        return lis;
    }
}
