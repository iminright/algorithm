/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _95_GenerateTrees.java, v 0.1 2021年02月26日 8:09 PM wanhaofan
 */
public class _95_GenerateTrees {

    public static List<TreeNode> generateTrees(int n) {
        int nums[] = new int[n];
        for(int i = 1; i <= n; i++){
            nums[i - 1] = i;
        }
        List<TreeNode> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            result.addAll(buildTree(nums, i, 0, nums.length - 1));
        }
        return result;
    }

    private static List<TreeNode> buildTree(int[] nums, int rootIndex, int from, int end){
        if(from > end){
            return null;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        List<TreeNode> leftTreeNodeArray = new ArrayList<>();
        for(int i = from; i <= rootIndex - 1; i++){
            List<TreeNode> leftTreeNodes = buildTree(nums, i, from, rootIndex - 1);
            if(leftTreeNodes != null){
                leftTreeNodeArray.addAll(leftTreeNodes);
            }
        }

        List<TreeNode> rightTreeNodeArray = new ArrayList<>();
        for(int i = rootIndex + 1; i <= end; i++){
            List<TreeNode> rightTreeNodes = buildTree(nums, i, rootIndex + 1, end);
            if(rightTreeNodes != null){
                rightTreeNodeArray.addAll(rightTreeNodes);
            }
        }

        if(leftTreeNodeArray.size() == 0 && rightTreeNodeArray.size() != 0){
            for(int j = 0; j < rightTreeNodeArray.size(); j++){
                TreeNode root = new TreeNode(nums[rootIndex]);
                root.left = null;
                root.right = rightTreeNodeArray.get(j);
                nodeList.add(root);
            }
        }else if(rightTreeNodeArray.size() == 0 && leftTreeNodeArray.size() != 0){
            for(int j = 0; j < leftTreeNodeArray.size(); j++){
                TreeNode root = new TreeNode(nums[rootIndex]);
                root.right = null;
                root.left = leftTreeNodeArray.get(j);
                nodeList.add(root);
            }
        }else if(rightTreeNodeArray.size() != 0 && leftTreeNodeArray.size() != 0){
            for(int i = 0; i < leftTreeNodeArray.size(); i++){
                for(int j = 0; j < rightTreeNodeArray.size(); j++){
                    TreeNode root = new TreeNode(nums[rootIndex]);
                    root.left = leftTreeNodeArray.get(i);
                    root.right = rightTreeNodeArray.get(j);
                    nodeList.add(root);
                }
            }
        }else{
            TreeNode root = new TreeNode(nums[rootIndex]);
            nodeList.add(root);
        }
        return nodeList;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }


}