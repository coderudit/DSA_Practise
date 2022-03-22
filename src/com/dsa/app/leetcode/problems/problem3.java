package com.dsa.app.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem3 {
    public static void main(String[] args) {
        problem3 obj = new problem3();
        int[] nums = {475, 428, 495, 14, 465, 34, 819, 252, 965, 874, 247, 180, 553, 660, 416, 99, 459, 875, 747, 710, 652, 718, 875, 873, 960, 853, 151, 412, 746, 495, 917, 904, 7, 475, 999, 299, 760, 192, 271, 39, 970, 781, 718, 163, 719, 505, 612, 428, 817, 889, 560, 546, 130, 691, 641, 724, 652, 705, 601, 588, 363, 626, 541, 548, 245, 185, 674, 843, 970, 732, 252, 216, 504, 541, 487, 174, 773, 430, 256, 460, 428, 180, 340, 364, 586, 720, 903, 612, 39, 670, 641, 797, 601, 238, 881, 568, 192, 806, 44, 356, 273, 86, 860, 650, 132, 52, 779, 817, 904, 73, 256, 390, 382, 298, 767, 271, 400, 118, 953, 413, 254, 164, 574, 40, 864, 56, 819, 89, 889, 910, 138, 331, 307, 893, 54, 71, 222, 841, 39, 674, 912, 35, 425, 440, 486, 502, 490, 185, 239, 781, 379, 548, 203, 103, 810, 912, 271, 49, 322, 709, 671, 103, 107, 207, 450, 511, 720, 268, 864, 807, 203, 293, 130, 252, 708, 7, 392, 379, 502, 660, 575, 16, 122, 44, 117, 226, 216, 923, 252, 322, 409, 142, 673, 541, 519, 843, 374, 451, 334, 139, 573, 584, 567, 142, 276, 200, 470, 483, 588, 717, 121, 65, 488, 906, 231, 35, 969, 56, 761, 843, 659, 288, 787, 860, 302, 132, 306, 40, 33, 156, 430, 775, 549, 723, 151, 673, 511, 839, 44, 440, 144, 631, 990, 40, 454, 483, 592, 917, 440, 107, 313, 617, 226, 838, 417, 364, 812, 24, 169, 986, 903, 494, 52, 875, 356, 107, 256, 727, 953, 488, 909, 424, 873, 298, 568, 288, 965, 592, 544, 39};
        int[] nums2 = {7, 14, 16, 24, 49, 54, 65, 71, 73, 86, 89, 99, 144, 156, 169, 174, 200, 207, 222, 231, 245, 247, 254, 268, 273, 276, 293, 302, 313, 331, 334, 340, 374, 382, 390, 392, 400, 409, 454, 465, 470, 490, 519, 544, 546, 553, 560, 584, 586, 617, 626, 631, 650, 691, 705, 727, 732, 767, 773, 775, 779, 787, 797, 810, 812, 841, 853, 881, 893, 906, 923, 960, 986, 990, 999};
        int[] nums3 = {14, 465, 247, 553, 99, 960, 853, 999, 560, 546, 691, 705, 626, 245, 732, 174, 773, 340, 586, 797, 881, 273, 86, 650, 779, 73, 390, 382, 767, 400, 254, 89, 331, 893, 54, 71, 222, 841, 490, 810, 49, 207, 268, 293, 392, 16, 923, 409, 519, 374, 334, 584, 276, 200, 470, 65, 906, 231, 787, 302, 156, 775, 144, 631, 990, 454, 313, 617, 812, 24, 169, 986, 727, 544};
        var newList = obj.findLonely(nums);
        System.out.println("");
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> newList = new ArrayList<>();
        if (nums.length == 1) {
            newList.add(nums[0]);
            return newList;
        } else if (nums.length == 2) {
            if (Math.abs(nums[0] - nums[1]) <= 1)
                return newList;
            else {
                newList.add(nums[0]);
                newList.add(nums[1]);
                return newList;
            }
        }


        Arrays.sort(nums);

        if (nums[1] - nums[0] > 1)
            newList.add(nums[0]);

        if (nums.length == 2)
            return newList;

        for (int index = 0; index < nums.length; index += 1) {
            if (index + 1 < nums.length
                    && nums[index + 1] - nums[index] > 1
                    && (index + 2 == nums.length || nums[index + 2] - nums[index + 1] > 1)
            ) {
                newList.add(nums[index + 1]);
            }
        }
        return newList;
    }
}