/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _105_buildTree_1.java, v 0.1 2021Äê03ÔÂ27ÈÕ 6:27 PM wanhaofan
 */
public class _105_BuildTree_3 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }


    private TreeNode buildTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder){
        if(preStart > preEnd){
            return null;
        }
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftTreeSize = index - inStart;
        root.left = buildTree(preStart + 1, preStart + leftTreeSize, preorder, inStart, index - 1, inorder);
        root.right = buildTree(preStart + leftTreeSize + 1, preEnd, preorder, index + 1, inEnd, inorder);
        return root;
    }

}