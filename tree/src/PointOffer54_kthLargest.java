/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version PointOffer54_kthLargest.java, v 0.1 2021年02月24日 11:15 PM wanhaofan
 */
public class PointOffer54_kthLargest {
    TreeNode largestNode;
    int kth = 0;
    public int kthLargest(TreeNode root, int k) {
        kth = k;
        findKthLargest(root);
        return largestNode.val;
    }

    private void findKthLargest(TreeNode node){
        if(node == null){
            return;
        }
        findKthLargest(node.right);
        kth--;
        if(kth == 0){
            largestNode = node;
            return;
        }
        findKthLargest(node.left);
    }
}