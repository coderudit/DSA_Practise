package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

public class _7_TrapRainWater {
    public static void main(String[] args) {
        _7_TrapRainWater problem = new _7_TrapRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(problem.trap(height));
    }

    public int trap(int[] height) {

        int left = 0; int right = height.length-1;

        int leftMax = 0; int rightMax= 0;
        int totalArea = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    totalArea += (leftMax - height[left]);
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    totalArea+= ( rightMax - height[right]);
                }
                right--;
            }
        }

        return totalArea;
    }
}
