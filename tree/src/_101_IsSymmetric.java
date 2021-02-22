/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _101_IsSymmetric.java, v 0.1 2021年02月21日 12:33 PM wanhaofan
 */
public class _101_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    /**
     * 这道题目和100思路一致,可以看作判断left.left == right.right && left.right == right.left
     * @param p
     * @param q
     * @return
     */
    private boolean isSymmetric(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p != null && q != null && p.val == q.val){
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
        return false;
    }

}