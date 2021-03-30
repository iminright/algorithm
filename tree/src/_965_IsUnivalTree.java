/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _965_IsUnivalTree.java, v 0.1 2021Äê03ÔÂ30ÈÕ 10:35 PM wanhaofan
 */
public class _965_IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val != root.val){
            return false;
        }
        if(root.right != null && root.right.val != root.val){
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}