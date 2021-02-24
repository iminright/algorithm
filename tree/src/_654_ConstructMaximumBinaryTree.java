/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _654_ConstructMaximumBinaryTree.java, v 0.1 2021年02月24日 9:26 PM wanhaofan
 */
public class _654_ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int nums[], int from, int end) {
        if (from > end) {
            return null;
        }
        int biggestNodeIndex = from;
        for (int i = from; i <= end; i++) {
            if (nums[i] > nums[biggestNodeIndex]) {
                biggestNodeIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[biggestNodeIndex]);
        int leftTreeEnd = biggestNodeIndex - 1;
        root.left = buildTree(nums, from, leftTreeEnd);
        int rightTreeFrom = biggestNodeIndex + 1;
        root.right = buildTree(nums, rightTreeFrom, end);
        return root;
    }

}