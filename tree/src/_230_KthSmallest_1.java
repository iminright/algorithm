/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _230_KthSmallest.java, v 0.1 2021年02月28日 11:13 AM wanhaofan
 */
public class _230_KthSmallest_1 {

    int K;
    TreeNode smallestNode;

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        findKthSmallest(root);
        return smallestNode.val;
    }

    private void findKthSmallest(TreeNode node){
        if(node == null){
            return;
        }
        findKthSmallest(node.left);
        K--;
        if(K == 0){
            smallestNode = node;
        }
        findKthSmallest(node.right);
    }

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _1 = new TreeNode(1);
        TreeNode _4 = new TreeNode(4);
        TreeNode _2 = new TreeNode(2);

        _3.left = _1;
        _3.right = _4;
        _1.right = _2;
        _230_KthSmallest_1 main = new _230_KthSmallest_1();
        System.out.println(main.kthSmallest(_3, 1));
    }

}