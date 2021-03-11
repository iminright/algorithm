/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _617_MergeTrees.java, v 0.1 2021Äê03ÔÂ11ÈÕ 3:36 PM wanhaofan
 */
public class _617_MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return preorder(root1, root2);
    }

    private TreeNode preorder(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            node1 = new TreeNode(node2.val);
        } else {
            node1.val += node2 == null ? 0 : node2.val;
        }
        node1.left = preorder(node1.left, node2 == null ? null : node2.left);
        node1.right = preorder(node1.right, node2 == null ? null : node2.right);
        return node1;
    }


}