package com.zhenbin.lzb.leetcode;

/**
 * Created by zhenbin.lzb on 2016/10/14.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class L297 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) return "";
        StringBuilder serializeString = new StringBuilder();
        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
        //push nodes
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode currentNode = treeNodes.poll();
            if (null == currentNode) {
                serializeString.append("," + NULL);
            } else {
                serializeString.append("," + currentNode.val);
                treeNodes.offer(currentNode.left);
                treeNodes.offer(currentNode.right);
            }

        }
        return serializeString.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] nodeStrings = data.split(",");

        TreeNode[] treeNodes = new TreeNode[nodeStrings.length];
        for (int i = 0; i < treeNodes.length; i++) {
            if (NULL.equals(nodeStrings[i])) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(Integer.valueOf(nodeStrings[i]));
            }
        }
        for (int i = 0, j = 1; i < treeNodes.length; i++) {
            TreeNode currentNode = treeNodes[i];
            if (null != currentNode) {
                currentNode.left = treeNodes[j++];
                currentNode.right = treeNodes[j++];
            }
        }
        return treeNodes[0];

    }
}
