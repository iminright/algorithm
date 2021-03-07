/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _543_DiameterOfBinaryTree.java, v 0.1 2021Äê03ÔÂ07ÈÕ 9:27 PM wanhaofan
 */
public class _543_DiameterOfBinaryTree {

    int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return diameter;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        diameter = Math.max(leftDepth + rightDepth, diameter);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}