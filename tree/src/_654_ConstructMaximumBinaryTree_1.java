/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _654_ConstructMaximumBinaryTree_1.java, v 0.1 2021Äê03ÔÂ27ÈÕ 6:20 PM wanhaofan
 */
public class _654_ConstructMaximumBinaryTree_1 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }

    private TreeNode buildTree(int start, int end, int[] nums){
        if(start > end){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = start; i <= end; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(start, maxIndex - 1, nums);
        root.right = buildTree(maxIndex + 1, end, nums);
        return root;
    }



}