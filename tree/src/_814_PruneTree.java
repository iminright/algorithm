/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _814_PruneTree.java, v 0.1 2021Äê03ÔÂ16ÈÕ 7:58 PM wanhaofan
 */
public class _814_PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dummyRoot = new TreeNode(-1);
        dummyRoot.left = root;
        allZero(root, dummyRoot);
        return root;
    }

    private boolean allZero(TreeNode node, TreeNode parent) {
        if (node == null) {
            return true;
        }
        boolean leftAllZero = allZero(node.left, node);
        if (leftAllZero) {
            node.left = null;
        }
        boolean rightAllZero = allZero(node.right, node);
        if (rightAllZero) {
            node.right = null;
        }
        if (node.val == 0 && rightAllZero && leftAllZero) {
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _814_PruneTree main = new _814_PruneTree();
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(0);
        TreeNode _3 = new TreeNode(1);
        TreeNode _4 = new TreeNode(0);
        TreeNode _5 = new TreeNode(0);
        TreeNode _6 = new TreeNode(0);
        TreeNode _7 = new TreeNode(1);
        _1.left = _2;
        _1.right = _3;
        _2.left = _4;
        _2.right = _5;
        _3.left = _6;
        _3.right = _7;
        main.pruneTree(_1);
    }
}