package com.zhenbin.lzb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melon on 16/10/9.
 */
public class L95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        //bug: n==0 return nodes.add(null) preveous
        if (n == 0)
            return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int front, int rear) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (front > rear) {
            nodes.add(null);
            return nodes;
        }
        for (int i = front; i <= rear; i++) {
            List<TreeNode> leftNodes = generateTrees(front, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, rear);
            for (int j = 0; j < leftNodes.size(); j++) {
                for (int k = 0; k < rightNodes.size(); k++) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = leftNodes.get(j);
                    newNode.right = rightNodes.get(k);
                    nodes.add(newNode);
                }
            }
        }
        return nodes;
    }
}
