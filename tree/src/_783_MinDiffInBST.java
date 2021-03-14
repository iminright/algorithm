/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _783_MinDiffInBST.java, v 0.1 2021Äê03ÔÂ14ÈÕ 10:58 PM wanhaofan
 */
public class _783_MinDiffInBST {

    int minDiff = Integer.MAX_VALUE;

    TreeNode pre;

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (pre != null) {
            minDiff = Math.min(node.val - pre.val, minDiff);
        }
        pre = node;
        inorderTraversal(node.right);
    }


    public static void main(String[] args) {
        TreeNode _27 = new TreeNode(27);
        TreeNode _34 = new TreeNode(34);
        TreeNode _58 = new TreeNode(58);
        TreeNode _50 = new TreeNode(50);
        TreeNode _44 = new TreeNode(44);
        _27.right = _34;
        _34.right = _58;
        _58.left = _50;
        _50.left = _44;
        _783_MinDiffInBST main = new _783_MinDiffInBST();
        System.out.println(main.minDiffInBST(_27));
    }


}