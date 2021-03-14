/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _701_InsertIntoBST.java, v 0.1 2021Äê03ÔÂ14ÈÕ 10:50 PM wanhaofan
 */
public class _701_InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        traverse(root, null, val);
        return root;
    }

    private void traverse(TreeNode node, TreeNode parent, int val) {
        if (node == null) {
            TreeNode newNode = new TreeNode(val);
            if (parent.val > val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            return;
        }
        if (node.val > val) {
            traverse(node.left, node, val);
        } else {
            traverse(node.right, node, val);
        }
    }

}