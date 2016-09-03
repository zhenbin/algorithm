package com.zhenbin.lzb.algorithm;

import com.zhenbin.lzb.node.AhoNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 */
public class Aho {
    private AhoNode head = new AhoNode();

    public AhoNode getHead() {
        return head;
    }

    // ���뵥�ʵ�trie��
    public void insert(String words) {
        AhoNode nodePoint = head;
        for (int i = 0; i < words.length(); i++) {
            int wordIndex = words.charAt(i) - 'a';
            if (null == nodePoint.next[wordIndex]) {
                nodePoint.next[wordIndex] = new AhoNode();
            }
            nodePoint = nodePoint.next[wordIndex];
        }
        nodePoint.isEnd = true;
    }

    public List<Integer> match(String words) {
        List<Integer> matchNums = new ArrayList<Integer>();
        AhoNode nodePoint = head;
        for (int i = 0; i < words.length(); i++) {
            int wordIndex = words.charAt(i) - 'a';
            nodePoint = nodePoint.next[wordIndex];
            if (nodePoint.isEnd) {
                System.out.println("end position is " + i);
                matchNums.add(i);
            }
        }
        return matchNums;
    }

    //�Ȳ��������е��ʣ�Ȼ����buildʧ��·��
    public void build() {
        Queue<AhoNode> queue = new LinkedList<AhoNode>();
        // �����Ƚ���һ��ڵ�ӽ���������Ϊ��һ��ڵ�ĵ�gotoNextֱ�����ó�head��������������
        // �͸�kmp�Ǵӵڶ���Ԫ�ؿ�ʼ����һ��
        for (int i = 0; i < AhoNode.NEXT_COUNT; i++) {
            if (null != head.next[i]) {
                queue.add(head.next[i]);
                head.next[i].gotoNext = head;
            } else {
                head.next[i] = head;
            }
        }
        while (!queue.isEmpty()) {
            AhoNode firstNode = queue.poll();
            for (int i = 0; i < AhoNode.NEXT_COUNT; i++) {
                if (null != firstNode.next[i]) {
                    firstNode.next[i].gotoNext = firstNode.gotoNext.next[i];
                    queue.add(firstNode.next[i]);
                } else {
                    firstNode.next[i] = firstNode.gotoNext.next[i];
                }
            }
        }
    }

    public void printTrie() {
        printTrie(head, "");
    }

    //��ӡtrie��
    private void printTrie(AhoNode node, String str) {
        if (node.isEnd) {
            System.out.println(str);
        }
        for (int i = 0; i < AhoNode.NEXT_COUNT; i++) {
            if (node.next[i] != null) {
                printTrie(node.next[i], str + (char) ('a' + i));
            }
        }
    }

}
