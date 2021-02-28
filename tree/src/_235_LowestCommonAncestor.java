/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _235_LowestCommonAncestor.java, v 0.1 2021年02月28日 11:45 AM wanhaofan
 */
public class _235_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }
        if (p.val >= root.val && q.val <= root.val) {
            return root;
        }
        if (p.val >= root.val && q.val >= root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val <= root.val && q.val <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return null;
        }
    }

}