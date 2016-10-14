package com.zhenbin.lzb.leetcode;

/**
 * Created by melon on 16/10/15.
 */
public class L80 {
    public int removeDuplicates(int[] nums) {
        int lastPosition = 0;
        for (int n : nums) {
            //这里不是跟index的前两个数比，而是跟已经加入列表的值来比。前者是有bug的，因为数据可能被覆盖掉
            if (lastPosition < 2 || n > nums[lastPosition - 2]) {
                nums[lastPosition++] = n;
            }
        }
        return lastPosition;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        L80 l80 = new L80();
        System.out.println(l80.removeDuplicates(nums));
    }
}
