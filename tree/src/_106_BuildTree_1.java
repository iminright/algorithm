/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _106_BuildTree_1.java, v 0.1 2021Äê03ÔÂ27ÈÕ 6:47 PM wanhaofan
 */
public class _106_BuildTree_1 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder,0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(postStart > postEnd){
            return null;
        }
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if(postorder[postEnd] == inorder[i]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rightSize = inEnd - index;
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postEnd - rightSize - 1);
        return root;
    }


}