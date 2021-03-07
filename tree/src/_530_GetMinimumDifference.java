/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _530_GetMinimumDifference.java, v 0.1 2021Äê03ÔÂ07ÈÕ 5:52 PM wanhaofan
 */
public class _530_GetMinimumDifference {

    int minimumDifference = Integer.MAX_VALUE;

    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            // whatever
            return -1;
        }
        inorderTraversal(root);
        return minimumDifference;
    }

    private void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        if(pre == -1){
            pre = node.val;
        }else{
            minimumDifference = Math.min(node.val - pre, minimumDifference);
            pre = node.val;
        }
        inorderTraversal(node.right);
    }

}