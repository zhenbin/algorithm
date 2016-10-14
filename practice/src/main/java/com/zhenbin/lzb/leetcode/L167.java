package com.zhenbin.lzb.leetcode;

/**
 * Created by melon on 16/10/9.
 */
public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        int beforeIndex = 0, behindIndex = numbers.length-1;
        while (beforeIndex < behindIndex) {
            int sum = numbers[beforeIndex] + numbers[behindIndex];
            if (sum < target) {
                beforeIndex++;
            } else if (sum > target) {
                behindIndex--;
            } else {
                int[] result = new int[2];
                result[0] = beforeIndex + 1;
                result[1] = behindIndex + 1;
                return result;
            }
        }
        return null;
    }
}
