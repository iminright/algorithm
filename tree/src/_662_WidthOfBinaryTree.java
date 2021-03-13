/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.*;

/**
 * @author wanhaofan
 * @version _662_WidthOfBinaryTree.java, v 0.1 2021Äê03ÔÂ13ÈÕ 10:27 AM wanhaofan
 */
public class _662_WidthOfBinaryTree {

    Map<Integer, Integer> mostLeftNodePosMap = new HashMap<>();
    int maxWidth = Integer.MIN_VALUE;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, 0, 0);
        return maxWidth;
    }

    private void traverse(TreeNode node, int pos, int depth) {
        if (node == null) {
            return;
        }
        mostLeftNodePosMap.computeIfAbsent(depth, x -> pos);
        maxWidth = Math.max(pos - mostLeftNodePosMap.get(depth) + 1, maxWidth);
        traverse(node.left, pos * 2, depth + 1);
        traverse(node.right, pos * 2 + 1, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _7 = new TreeNode(7);
        _1.left = _2;
        _1.right = _3;
        _2.left = _4;
        _2.right = _5;
        _3.right = _7;
        _662_WidthOfBinaryTree main = new _662_WidthOfBinaryTree();
        main.widthOfBinaryTree(_1);
    }

}