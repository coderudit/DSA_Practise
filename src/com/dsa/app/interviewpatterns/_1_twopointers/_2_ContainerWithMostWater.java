package com.dsa.app.interviewpatterns._1_twopointers;

public class _2_ContainerWithMostWater {
    public static void main(String[] args) {
        _2_ContainerWithMostWater program = new _2_ContainerWithMostWater();
        int[] height = {1, 3, 2, 5, 25, 24, 5};
        System.out.println(program.maxArea(height));
    }

    public int maxArea(int[] height) {
        int startIndex = 0;
        int endIndex = height.length - 1;

        int prevArea = Integer.MIN_VALUE;
        while (startIndex < endIndex) {

            int currentArea = (endIndex - startIndex) * Math.min(height[startIndex], height[endIndex]);
            prevArea = Math.max(prevArea, currentArea);

            if (height[startIndex] > height[endIndex])
                endIndex--;
            else
                startIndex++;

        }
        return prevArea;
    }

}
