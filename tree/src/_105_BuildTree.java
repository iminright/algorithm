/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 假设树中没有重复的元素
 * @author wanhaofan
 * @version _105_BuildTree.java, v 0.1 2021年02月22日 2:22 PM wanhaofan
 */
public class _105_BuildTree {

    /**
     * nodeVal -> inorderIndex
     */
    private Map<Integer, Integer> inorderMemo = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        for(int i = 0; i < inorder.length; i++){
            inorderMemo.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preorderRootIndex, int[] inorder, int inorderBeginIndex, int inorderEndIndex){
        if(inorderBeginIndex >= inorderEndIndex){
            return new TreeNode(inorder[inorderBeginIndex]);
        }
        TreeNode root = new TreeNode(preorder[preorderRootIndex]);
        int inorderRootIndex = inorderMemo.get(preorder[preorderRootIndex]);
        int leftSubTreeInorderBeginIndex = inorderBeginIndex;
        int leftSubTreeInorderEndIndex = inorderRootIndex - 1;
        int rightSubTreeInorderBeginIndex = inorderRootIndex + 1;
        int rightSubTreeInorderEndIndex = inorderEndIndex;

        int leftChildIndex = -1;
        if(leftSubTreeInorderEndIndex >= inorderBeginIndex){
            // 说明存在左子树
            // 那 preorder[preorderRootIndex + 1]一定是左子树的root节点
            leftChildIndex = preorderRootIndex + 1;
        }

        int rightChildIndex = -1;
        if(rightSubTreeInorderBeginIndex <= inorderEndIndex){
            // 说明存在右子树
            // 那 preorder[preorderRootIndex + leftTreeNodeSize + 1]一定是右子树的root节点
            rightChildIndex = preorderRootIndex + (inorderRootIndex - inorderBeginIndex) + 1;
        }

        if(leftChildIndex != -1){
            TreeNode leftSubTree = buildTree(preorder, leftChildIndex, inorder, leftSubTreeInorderBeginIndex, leftSubTreeInorderEndIndex);
            root.left = leftSubTree;
        }
        if(rightChildIndex != -1){
            TreeNode rightSubTree = buildTree(preorder, rightChildIndex, inorder, rightSubTreeInorderBeginIndex, rightSubTreeInorderEndIndex);
            root.right = rightSubTree;
        }
        return root;
    }

}