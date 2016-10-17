package com.zhenbin.lzb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melon on 16/10/15.
 */
public class L229 {
    public List<Integer> majorityElement(int[] nums) {
        int[] majorityElements = new int[2];
        int[] majorityCount = new int[2];
        for (int num : nums) {
            if (majorityCount[0] > 0 && majorityCount[1] > 0 && majorityElements[0] != num && majorityElements[1] != num) {
                majorityCount[0]--;
                majorityCount[1]--;
            } else if ((majorityCount[0] > 0 && majorityElements[0] == num) || (majorityCount[1] > 0 && majorityElements[1] != num)) {
                majorityElements[0] = num;
                majorityCount[0]++;
            } else {
                majorityElements[1] = num;
                majorityCount[1]++;
            }
        }
        majorityCount[0] = majorityCount[1] = 0;
        for (int num : nums) {
            if (majorityElements[0] == num) majorityCount[0]++;
            else if (majorityElements[1] == num) majorityCount[1]++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if (majorityCount[0] > nums.length / 3) result.add(majorityElements[0]);
        if (majorityCount[1] > nums.length / 3) result.add(majorityElements[1]);
        return result;
    }
}
