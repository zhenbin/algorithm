package com.zhenbin.lzb.algorithm;

/**
 * Created by zhenbin.lzb on 2016/9/6.
 */
public class Topological {
    /**
     * 作用：拓扑图里，输出一种可能的拓扑排序
     *
     * 数据结构：
     *  inEdgeNum[n]: 保存每个结点的入度大小
     *  outEdge[n][n]: 保存每个结节对应的直接下游结点
     *
     * 算法：
     * 把所有入度为0的点加入队列
     * while (队列不为空):
     *  取出队列头的点
     *  while (i是队列头的下游点):
     *      inEdgeNum[i]--;
     *      if (inEdgeNum[i] == 0):
     *          加入队列
     *
     * 时间复杂度：O(n + v)
     */
}
