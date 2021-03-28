/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _105_buildTree_1.java, v 0.1 2021年03月27日 6:27 PM wanhaofan
 */
public class _105_buildTree_1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0 , preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //在中序遍历数组中的分界点
        Integer index = null;
        for (int i = inStart; i <= inEnd; i++) {
            if(preorder[preStart] == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = buildTree(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

}