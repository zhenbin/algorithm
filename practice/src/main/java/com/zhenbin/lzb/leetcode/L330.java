package com.zhenbin.lzb.leetcode;

/**
 * Created by zhenbin.lzb on 2016/10/15.
 */
public class L330 {
    public int minPatches(int[] nums, int n) {
        int requiredCount = 0;
        long currentMount = 0;
        int len = nums.length;
        int numsIndex = 0;
        while (currentMount < n) {
            if (numsIndex < len && currentMount >= nums[numsIndex]-1) {
                currentMount += nums[numsIndex++];
            } else {
                //因为n可以是任意integer，所以这里的currentMount * 2时可能溢出，所以把它设成了long
                currentMount = currentMount * 2 + 1;
                requiredCount++;
            }
        }
        return requiredCount;
    }
}
