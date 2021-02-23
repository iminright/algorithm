/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _110_IsBalanced.java, v 0.1 2021年02月23日 6:02 PM wanhaofan
 */
public class _110_IsBalanced {

    /**
     * 前序遍历的思维,自顶向下遍历,T=O(n*h),n是节点个数,h是树的高度
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
    }

}