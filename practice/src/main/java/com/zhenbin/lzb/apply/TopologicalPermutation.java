package com.zhenbin.lzb.apply;

import com.zhenbin.lzb.Utils;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class TopologicalPermutation {
    /**
     * 带有先后顺序限制的排列组合
     */

    //保存每个结点的入度大小
    private int[] inEdgeNum;
    //保存每个结节对应的直接下游结点，出边的数目保存在outEdge[][0]里
    private int[][] outEdge;

    private int nodeNum;

    public TopologicalPermutation(int nodeNum) {
        this.nodeNum = nodeNum;
        inEdgeNum = new int[nodeNum];
        outEdge = new int[nodeNum][];
        for (int i = 0; i < nodeNum; i++) {
            outEdge[i] = new int[nodeNum];
        }
    }

    //加入限制条件：from 在 to 前面
    public void addEdge(int from, int to) {
        outEdge[from][++outEdge[from][0]] = to;
        inEdgeNum[to]++;
    }


    public void topologicalPermutation() {
        int[] nodeForOutput = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            nodeForOutput[i] = i;
        }
        topologicalPermutation(nodeForOutput, 0);
    }

    //开始深度搜索
    private void topologicalPermutation(int[] nodeForOutput, int depth) {
        if (depth == nodeNum) {
            for (int i = 0; i < nodeForOutput.length; i++) {
                System.out.print(" " + nodeForOutput[i]);
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < nodeForOutput.length; i++) {
            if (inEdgeNum[nodeForOutput[i]] == 0) {
                Utils.swap(nodeForOutput, depth, i);
                //去掉点的指向边
                for (int j = 1; j <= outEdge[nodeForOutput[depth]][0]; j++) {
                    inEdgeNum[outEdge[nodeForOutput[depth]][j]]--;
                }
                //开始搜索
                topologicalPermutation(nodeForOutput, depth + 1);
                //搜索完后，加回点的指向边，一切恢复到没发生过之前的情况
                for (int j = 1; j <= outEdge[nodeForOutput[depth]][0]; j++) {
                    inEdgeNum[outEdge[nodeForOutput[depth]][j]]++;
                }
                //搜索完后，两个数再调回来，一切恢复到没发生过之前的情况
                Utils.swap(nodeForOutput, depth, i);
            }
        }
    }

    public static void main(String[] args) {
        TopologicalPermutation topologicalPermutation = new TopologicalPermutation(5);
        topologicalPermutation.addEdge(0, 1);
        topologicalPermutation.addEdge(2, 3);
        topologicalPermutation.topologicalPermutation();

    }
}
