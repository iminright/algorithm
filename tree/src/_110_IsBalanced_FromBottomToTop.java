/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _110_IsBalanced_FromBottomToTop.java, v 0.1 2021年02月23日 6:16 PM wanhaofan
 */
public class _110_IsBalanced_FromBottomToTop {

    /**
     * 采用后序遍历的思维,自底向上遍历,这样树的高度不会重复计算,T=O(n)
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(node.right);
        if (rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

}