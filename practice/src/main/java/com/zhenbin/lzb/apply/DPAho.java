package com.zhenbin.lzb.apply;

import com.zhenbin.lzb.algorithm.Aho;
import com.zhenbin.lzb.node.AhoNode;

/**
 * Created by zhenbin.lzb on 2016/9/2.
 * UVA11468
 */
public class DPAho {
    private Aho aho = new Aho();
    public final static int STEPS = 1000;

    public void updateValues(AhoNode ahoNode) {
        if (null != ahoNode.otherValues) {
            return;
        }
        Double[] p = new Double[STEPS];
        p[0] = 1.0;
        if (ahoNode.isEnd) {
            for (int i = 0; i < p.length; i++) p[i] = 0.0;
        }
        ahoNode.otherValues = p;
        for (int i = 0; i < AhoNode.NEXT_COUNT; i++) {
            updateValues(ahoNode.next[i]);
        }
    }

    public double properties(int kStep) {
        return properties(aho.getHead(), kStep);
    }

    private double properties(AhoNode node, int kStep) {
        Double[] p = (Double[]) node.otherValues;
        if (p[kStep] != null) {
            return p[kStep];
        }
        p[kStep] = 0.0;
        for (int i = 0; i < AhoNode.NEXT_COUNT; i++) {
            p[kStep] += properties(node.next[i], kStep - 1) / AhoNode.NEXT_COUNT;
        }
        return p[kStep];
    }


    /**
     * 判断随机生成的长度为k的字符串里，不出现以下字符串的概率。
     * 思路：在每个结点里放入p[]，其中p[i]表示从这个节点出发走i步后不出现限制字符串的概率。
     * @param args
     */
    public static void main(String[] args) {
        DPAho dpAho = new DPAho();
        Aho aho = dpAho.aho;
        aho.insert("a");
        aho.insert("b");
        aho.insert("d");
        aho.insert("cd");
        aho.build();

        dpAho.updateValues(aho.getHead());
        System.out.println(dpAho.properties(1));
        System.out.println(dpAho.properties(2));
        System.out.println(dpAho.properties(200));
    }
}
