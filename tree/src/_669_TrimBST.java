/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _669_TrimBST.java, v 0.1 2021年03月13日 12:59 PM wanhaofan
 */
public class _669_TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        doTrim(root, dummy, true, low, high);
        return dummy.left;
    }

    private TreeNode doTrim(TreeNode node, TreeNode parent, boolean isLeftChild, int low, int high) {
        if (node == null) {
            return null;
        }
        if (node.val > high) {
            // 当前节点及其右子树都需要被删除
            node.right = null;
            // 需要trim左边
            TreeNode newNode = doTrim(node.left, node, true, low, high);
            if (isLeftChild) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            node = null;
            return newNode;
        } else if (node.val < low) {
            // 当前节点及其左子树都需要被删除
            node.left = null;
            // 需要trim右边
            TreeNode newNode = doTrim(node.right, node, false, low, high);
            if (isLeftChild) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            node = null;
            return newNode;
        } else {
            // 左右都需要trim
            doTrim(node.left, node, true, low, high);
            doTrim(node.right, node, false, low, high);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _2 = new TreeNode(2);
        _3.left = _1;
        _3.right = _4;
        _1.right = _2;
        _669_TrimBST main = new _669_TrimBST();
        main.trimBST(_3, 3, 4);
    }
}