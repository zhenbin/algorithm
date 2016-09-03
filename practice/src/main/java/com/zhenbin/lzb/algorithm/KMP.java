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

    //����next����
    private void initNext() {
        //kmp��һ��ȷ������״̬��(DFA)������-1�����ʼ״̬�Ľڵ�
        next[0] = -1;
        for (int i = 1; i < matchingStr.length; i++) {
            int point = next[i - 1];
            while (point >= 0 && matchingStr[point + 1] != matchingStr[i]) {
                //point�ڵ��next[point]�������ͬ����ĸ
                point = next[point];
            }
            next[i] = matchingStr[point + 1] == matchingStr[i] ? point + 1 : -1;
        }
    }

    /**
     * ��targetString����ƥ�䣬����ƥ����ʱ��targetString��ͷ���±�
     * ��δƥ�䷵��-1
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
