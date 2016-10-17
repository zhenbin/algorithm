package com.zhenbin.lzb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhenbin.lzb on 2016/10/17.
 */
public class Solution {
    private String targetString;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<Integer>[] nextStart = new List[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            nextStart[i] = new ArrayList<Integer>();
            String subString = "";
            for (int j = i; j < s.length(); j++) {
                subString += s.charAt(j);
                if (!wordDict.contains(subString)) break;
                if (j == s.length() -1 || nextStart[j+1].size() != 0) {
                    nextStart[i].add(j+1);
                }
            }
        }

        targetString = s;
        List<String> result = new ArrayList<String>();
        addResult("", 0, result, nextStart);
        return result;
    }

    private void addResult(String preString, int index, List<String> result, List<Integer>[] nextStart) {
        for (Integer next : nextStart[index]) {
            if (next == targetString.length()) {
                result.add(preString + targetString.substring(index));
            } else {
                addResult(preString + targetString.substring(index, next) + " ", next, result, nextStart);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> set = new HashSet<String>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        Solution solution = new Solution();
        solution.wordBreak(s, set);
    }
}
