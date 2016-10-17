package com.zhenbin.lzb.leetcode;

/**
 * Created by zhenbin.lzb on 2016/10/17.
 */
public class L41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //bug: 刚开始的时候没有用while，结果有的数被换到了前面来，而到不它要去的位置[3,4,-1,1]
            //bug: 直接用nums[i] != i+1，结果有重复数字的时候死循环
            while (0 < nums[i] && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
