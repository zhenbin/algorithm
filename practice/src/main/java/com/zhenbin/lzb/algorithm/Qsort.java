package com.zhenbin.lzb.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhenbin.lzb on 2016/9/4.
 */
public class Qsort {
    public <T extends Comparable<? super T>> void qSort(List<T> nums) {
        qSort(nums, 0, nums.size() - 1);
    }

    private <T> void swap(List<T> nums, int i, int j) {
        T temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    private <T extends Comparable<? super T>> void qSort(List<T> nums, int start, int end) {
        if (start >= end) return;
        //swapPosition指向第一个大于等于nums[start]的数
        int swapPosition = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums.get(i).compareTo(nums.get(start)) < 0) {
                swap(nums, i, swapPosition++);
            }
        }
        swap(nums, start, swapPosition - 1);
        qSort(nums, start, swapPosition - 2);
        qSort(nums, swapPosition, end);
    }

    public static void main(String[] args) {
        Qsort qsort = new Qsort();

        Integer[] nums = {8, 10, 32, 11, 32, 1, 7, 3, 5, 6, 9, 2, 100, 100, 100};
        qsort.qSort(Arrays.asList(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        String[] strs = {"ab", "abc", "a"};
        qsort.qSort(Arrays.asList(strs));
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + " ");
        }
    }
}
