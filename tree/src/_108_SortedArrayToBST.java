/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _108_SortedArrayToBST.java, v 0.1 2021年02月23日 5:22 PM wanhaofan
 */
public class _108_SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int nums[], int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return null;
        }
        int rootIndex = beginIndex + (endIndex - beginIndex) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        TreeNode leftTree = buildTree(nums, beginIndex, rootIndex - 1);
        TreeNode rightTree = buildTree(nums, rootIndex + 1, endIndex);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

}