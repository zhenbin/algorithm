package com.zhenbin.lzb.apply;

import com.zhenbin.lzb.Utils;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class TopologicalPermutation {
    /**
     * �����Ⱥ�˳�����Ƶ��������
     */

    //����ÿ��������ȴ�С
    private int[] inEdgeNum;
    //����ÿ����ڶ�Ӧ��ֱ�����ν�㣬���ߵ���Ŀ������outEdge[][0]��
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

    //��������������from �� to ǰ��
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

    //��ʼ�������
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
                //ȥ�����ָ���
                for (int j = 1; j <= outEdge[nodeForOutput[depth]][0]; j++) {
                    inEdgeNum[outEdge[nodeForOutput[depth]][j]]--;
                }
                //��ʼ����
                topologicalPermutation(nodeForOutput, depth + 1);
                //������󣬼ӻص��ָ��ߣ�һ�лָ���û������֮ǰ�����
                for (int j = 1; j <= outEdge[nodeForOutput[depth]][0]; j++) {
                    inEdgeNum[outEdge[nodeForOutput[depth]][j]]++;
                }
                //��������������ٵ�������һ�лָ���û������֮ǰ�����
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
