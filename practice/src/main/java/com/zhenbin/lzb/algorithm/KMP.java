package com.zhenbin.lzb.algorithm;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class KMP {
    private char[] matchingStr;
    private int[] next;

    public KMP(String matchingString) {
        matchingStr = matchingString.toCharArray();
        next = new int[matchingString.length()];
        initNext();
    }

    //生成next数组
    private void initNext() {
        //kmp是一个确定有限状态机(DFA)，其中-1代表初始状态的节点
        next[0] = -1;
        for (int i = 1; i < matchingStr.length; i++) {
            int point = next[i - 1];
            while (point >= 0 && matchingStr[point + 1] != matchingStr[i]) {
                //point节点和next[point]结节是相同的字母
                point = next[point];
            }
            next[i] = matchingStr[point + 1] == matchingStr[i] ? point + 1 : -1;
        }
    }

    /**
     * 对targetString进行匹配，返回匹配中时在targetString开头的下标
     * 如未匹配返回-1
     */
    public int matchString(String targetString) {
        char[] targetStr = targetString.toCharArray();
        int matchingStrPoint = -1;
        for (int i = 0; i < targetStr.length; i++) {
            while (matchingStrPoint >= 0 && matchingStr[matchingStrPoint + 1] != targetStr[i]) {
                matchingStrPoint = next[matchingStrPoint];
            }
            matchingStrPoint = matchingStr[matchingStrPoint + 1] == targetStr[i] ? matchingStrPoint + 1 : -1;
            if (matchingStrPoint == matchingStr.length - 1)
                return i + 1 - matchingStr.length;
        }
        return -1;
    }
}
