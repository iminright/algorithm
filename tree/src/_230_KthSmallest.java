/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _230_KthSmallest.java, v 0.1 2021年02月28日 11:13 AM wanhaofan
 */
public class _230_KthSmallest {

    TreeNode smallestNode;
    int kth = 0;
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        findKthSmallest(root);
        return smallestNode.val;
    }

    private void findKthSmallest(TreeNode node){
        if(node == null){
            return;
        }
        findKthSmallest(node.left);
        kth--;
        if(kth == 0){
            smallestNode = node;
            return;
        }
        findKthSmallest(node.right);
    }

}