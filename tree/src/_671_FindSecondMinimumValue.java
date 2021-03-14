/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _671_FindSecondMinimumValue.java, v 0.1 2021Äê03ÔÂ14ÈÕ 6:19 PM wanhaofan
 */
public class _671_FindSecondMinimumValue {

    int secMin = -1;

    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        return secMin;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        } else {
            if (node.left.val == node.val && node.right.val == node.val) {
                traverse(node.left);
                traverse(node.right);
            } else {
                if (node.left.val == node.val) {
                    if (secMin < 0) {
                        secMin = node.right.val;
                    } else {
                        secMin = Math.min(secMin, node.right.val);
                    }
                    traverse(node.left);
                } else {
                    traverse(node.right);
                    if (secMin < 0) {
                        secMin = node.left.val;
                    } else {
                        secMin = Math.min(secMin, node.left.val);
                    }
                }
            }
        }
    }
}