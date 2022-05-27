package com.dsa.app.leetcode.monthlychallenge.may;

public class _26_NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans=0;
        while(n!=0)
        {
            n=n & (n-1);
            ans++;
        }
        return ans;
    }
}
