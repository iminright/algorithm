/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;

/**
 * @author wanhaofan
 * @version _958_IsCompleteTree.java, v 0.1 2021Äê03ÔÂ30ÈÕ 10:07 PM wanhaofan
 */
public class _958_IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean findNotFullNode = false;
        while (queue.peek() != null) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (findNotFullNode && (node.left != null || node.right != null)) {
                    return false;
                }
                if (node.left == null || node.right == null) {
                    findNotFullNode = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _958_IsCompleteTree main = new _958_IsCompleteTree();
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
        System.out.println(main.isCompleteTree(_1));
    }

}