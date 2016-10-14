package com.zhenbin.lzb.leetcode;

import java.util.Stack;

/**
 * Created by melon on 16/10/14.
 */
public class L84 {
    public class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            int result = 0;
            Stack<Integer> increasedHeightIndex = new Stack<Integer>();
            for (int i = 0; i <= len; i++) {
                int currentHeight = 0;
                if (i < len) currentHeight = heights[i];
                while (!increasedHeightIndex.isEmpty() && heights[increasedHeightIndex.peek()] >= currentHeight) {
                    int height = heights[increasedHeightIndex.pop()];
                    int preIndex = increasedHeightIndex.isEmpty() ? -1 : increasedHeightIndex.peek();
                    int currentResult = height * (i - preIndex - 1);
                    //当把它弹出来的时候，这个时候就是它能够达到的最右边的时候了，可知它最右边可以到达i的位置。
                    result = result > currentResult ? result : currentResult;
                }
                increasedHeightIndex.push(i);
            }
            return result;
        }
    }
}
