package com.zhenbin.lzb;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class Utils {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
