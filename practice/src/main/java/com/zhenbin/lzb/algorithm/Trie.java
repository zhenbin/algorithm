package com.zhenbin.lzb.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class Trie {
    private class TrieNode {
        public boolean isEnd;
        public TrieNode[] next;
        public final static int NEXT_COUNT = 26;      //26个小写字母

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[NEXT_COUNT];
        }
    }

    private TrieNode head = new TrieNode();

    // 插入单词到trie树
    public void insert(String words) {
        TrieNode nodePoint = head;
        for (int i = 0; i < words.length(); i++) {
            int wordIndex = words.charAt(i) - 'a';
            if (null == nodePoint.next[wordIndex]) {
                nodePoint.next[wordIndex] = new TrieNode();
            }
            nodePoint = nodePoint.next[wordIndex];
        }
        nodePoint.isEnd = true;
    }

    public List<Integer> match(String words) {
        List<Integer> matchNums = new ArrayList<Integer>();
        TrieNode nodePoint = head;
        for (int i = 0; i < words.length(); i++) {
            int wordIndex = words.charAt(i) - 'a';
            if (null == nodePoint.next[wordIndex])
                return matchNums;
            nodePoint = nodePoint.next[wordIndex];
            if (nodePoint.isEnd) {
                matchNums.add(i + 1);
            }
        }
        return matchNums;
    }

    public void printTrie() {
        printTrie(head, "");
    }

    //打印trie树
    private void printTrie(TrieNode node, String str) {
        if (node.isEnd) {
            System.out.println(str);
        }
        for (int i = 0; i < TrieNode.NEXT_COUNT; i++) {
            if (node.next[i] != null) {
                printTrie(node.next[i], str + (char) ('a' + i));
            }
        }
    }

}
