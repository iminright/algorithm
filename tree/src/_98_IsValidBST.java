/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _98_IsValidBST.java, v 0.1 2021年02月16日 5:44 PM wanhaofan
 */
public class _98_IsValidBST {
    static TreeNode prev;

    /**
     * 使用中序遍历,但是要加上额外的限制条件,中序遍历的前一个节点必须比当前节点值更小
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        _2.left = _1;
        _1.right = _3;
        System.out.println(isValidBST(_2));
    }
}