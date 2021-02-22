/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _106_BuildTree.java, v 0.1 2021年02月22日 4:26 PM wanhaofan
 */
public class _106_BuildTree {

    /**
     * nodeVal -> inorderIndex
     */
    private Map<Integer, Integer> inorderMemo = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        for(int i = 0; i < inorder.length; i++){
            inorderMemo.put(inorder[i], i);
        }
        return buildTree(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postorderRootIndex, int[] inorder, int inorderBeginIndex, int inorderEndIndex){
        if(inorderBeginIndex >= inorderEndIndex){
            return new TreeNode(inorder[inorderBeginIndex]);
        }
        TreeNode root = new TreeNode(postorder[postorderRootIndex]);
        int inorderRootIndex = inorderMemo.get(postorder[postorderRootIndex]);
        int leftSubTreeInorderBeginIndex = inorderBeginIndex;
        int leftSubTreeInorderEndIndex = inorderRootIndex - 1;
        int rightSubTreeInorderBeginIndex = inorderRootIndex + 1;
        int rightSubTreeInorderEndIndex = inorderEndIndex;

        int leftChildIndex = -1;
        if(leftSubTreeInorderEndIndex >= inorderBeginIndex){
            // 说明存在左子树
            // 那 postorder[postorderRootIndex - rightTreeNodeSize - 1]一定是左子树的root节点
            leftChildIndex = postorderRootIndex - (rightSubTreeInorderEndIndex - rightSubTreeInorderBeginIndex + 1) - 1;
        }

        int rightChildIndex = -1;
        if(rightSubTreeInorderBeginIndex <= inorderEndIndex){
            // 说明存在右子树
            // 那 postorder[postorderRootIndex - 1]一定是右子树的root节点
            rightChildIndex = postorderRootIndex - 1;;
        }

        if(leftChildIndex != -1){
            TreeNode leftSubTree = buildTree(postorder, leftChildIndex, inorder, leftSubTreeInorderBeginIndex, leftSubTreeInorderEndIndex);
            root.left = leftSubTree;
        }
        if(rightChildIndex != -1){
            TreeNode rightSubTree = buildTree(postorder, rightChildIndex, inorder, rightSubTreeInorderBeginIndex, rightSubTreeInorderEndIndex);
            root.right = rightSubTree;
        }
        return root;
    }

}