/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _105_buildTree_1.java, v 0.1 2021年03月27日 6:27 PM wanhaofan
 */
public class _105_BuildTree_2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }

    /**
     * 对于该递归的定义我觉得要这样理解
     * 1.原问题是给定一个二叉树的前序遍历和中序遍历来还原
     * 2.每次要递归的小问题是
     *      2-1.如何构造根节点以及他的左右子树？
     *      2-2.结束条件?
     * 3.假设我们将小问题定义为 通过前序遍历中的一部分和中序遍历的一部分是否能还原出一棵树？
     * 4.小问题到最后是否能解决原问题？可以
     * @param preStart
     * @param preEnd
     * @param preorder
     * @param inStart
     * @param inEnd
     * @param inorder
     * @return
     */
    private TreeNode buildTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder){
        if(preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]){
                index = i;
                break;
            }
        }
        int leftSubTreeSize = index - inStart;
        root.left = buildTree(preStart + 1, preStart + leftSubTreeSize, preorder, inStart, index - 1, inorder);
        root.right = buildTree(preStart + leftSubTreeSize + 1, preEnd, preorder, index + 1, inEnd, inorder);
        return root;
    }

}