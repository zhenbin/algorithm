package com.zhenbin.lzb.algorithm;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class Topological {
    /**
     * ���ã�����ͼ����һ�ֿ��ܵ���������
     *
     * ���ݽṹ��
     *  inEdgeNum[n]: ����ÿ��������ȴ�С
     *  outEdge[n][n]: ����ÿ����ڶ�Ӧ��ֱ�����ν��
     *
     * �㷨��
     * ���������Ϊ0�ĵ�������
     * while (���в�Ϊ��):
     *  ȡ������ͷ�ĵ�
     *  while (i�Ƕ���ͷ�����ε�):
     *      inEdgeNum[i]--;
     *      if (inEdgeNum[i] == 0):
     *          �������
     *
     * ʱ�临�Ӷȣ�O(n + v)
     */
}
