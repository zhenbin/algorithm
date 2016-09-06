package com.zhenbin.lzb.algorithm;

/**
 * Created by zhenbin.lzb on 2016/9/4.
 */
public class Qsort {
    public void qSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void qSort(int[] nums, int start, int end) {
        if (start >= end) return;
        //swapPosition指向第一个大于等于nums[start]的数
        int swapPosition = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                swap(nums, i, swapPosition++);
            }
        }
        swap(nums, start, swapPosition - 1);
        qSort(nums, start, swapPosition - 2);
        qSort(nums, swapPosition, end);
    }

    public static void main(String[] args) {
        int[] nums = {8, 10, 32, 11, 32, 1, 7, 3, 5, 6, 9, 2, 100, 100, 100};
        Qsort qsort = new Qsort();
        qsort.qSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
