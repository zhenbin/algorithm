package com.zhenbin.lzb.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by melon on 16/10/14.
 */
public class L403 {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> toSteps = new HashMap<Integer, HashSet<Integer>>();
        for (int stone : stones) {
            toSteps.put(stone, new HashSet<Integer>());
        }
        toSteps.get(0).add(1);
        for (int stone : stones) {
            for (int nextStep : toSteps.get(stone)) {
                HashSet<Integer> nextSet = toSteps.get(stone + nextStep);
                if (null != nextSet) {
                    if (nextStep > 1) nextSet.add(nextStep-1);
                    nextSet.add(nextStep);
                    nextSet.add(nextStep + 1);
                }
            }
        }
        if (toSteps.get(stones[stones.length-1]).size() != 0) return true;
        return false;
    }
    public static void main(String[] args) {
//        HashSet
    }
}
