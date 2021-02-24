/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _897_IncreasingBST.java, v 0.1 2021年02月24日 10:01 PM wanhaofan
 */
public class _897_IncreasingBST {
    /**
     * 也可以使用中序遍历 上一个节点 的特性
     * https://leetcode-cn.com/problems/increasing-order-search-tree/solution/di-zeng-shun-xu-cha-zhao-shu-by-leetcode/
     * 解法二需要时刻温习并且习惯
     *
     * @param root
     * @return
     */
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = findMostLeftNode(root);
        inorder(root);
        return result;
    }

    private static TreeNode findMostLeftNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return findMostLeftNode(node.left);
    }

    private static TreeNode findMostRightNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return findMostRightNode(node.right);
    }

    private static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (node.left != null) {
            findMostRightNode(node.left).right = node;
            node.left = null;
        }
        TreeNode mostLeftNodeInRightTree = findMostLeftNode(node.right);
        inorder(node.right);
        if (node.right != null) {
            node.right = mostLeftNodeInRightTree;
        }
    }

    public static void main(String[] args) {
        TreeNode _5 = new TreeNode(5);
        TreeNode _3 = new TreeNode(3);
        TreeNode _6 = new TreeNode(6);
        TreeNode _2 = new TreeNode(2);
        TreeNode _8 = new TreeNode(8);
        TreeNode _4 = new TreeNode(4);
        TreeNode _1 = new TreeNode(1);
        TreeNode _7 = new TreeNode(7);
        TreeNode _9 = new TreeNode(9);

        _5.left = _3;
        _5.right = _6;
        _3.left = _2;
        _3.right = _4;
        _2.left = _1;
        _5.right = _6;
        _6.right = _8;
        _8.left = _7;
        _8.right = _9;
        TreeNode result = increasingBST(_5);
        System.out.println(result);
    }

}