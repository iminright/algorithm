/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _105_buildTree_1.java, v 0.1 2021��03��27�� 6:27 PM wanhaofan
 */
public class _105_BuildTree_2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }

    /**
     * ���ڸõݹ�Ķ����Ҿ���Ҫ�������
     * 1.ԭ�����Ǹ���һ����������ǰ������������������ԭ
     * 2.ÿ��Ҫ�ݹ��С������
     *      2-1.��ι�����ڵ��Լ���������������
     *      2-2.��������?
     * 3.�������ǽ�С���ⶨ��Ϊ ͨ��ǰ������е�һ���ֺ����������һ�����Ƿ��ܻ�ԭ��һ������
     * 4.С���⵽����Ƿ��ܽ��ԭ���⣿����
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