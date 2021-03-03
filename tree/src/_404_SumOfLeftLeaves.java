/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _404_SumOfLeftLeaves.java, v 0.1 2021年03月03日 8:34 PM wanhaofan
 */
public class _404_SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft){
        if(node == null){
            return 0;
        }
        if(isLeft && node.left == null && node.right == null){
            return node.val;
        }
        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }

}