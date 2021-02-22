/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _114_Flatten.java, v 0.1 2021年02月15日 12:35 PM wanhaofan
 */
public class _114_Flatten {

    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    /**
     * doFlatten的定义为将node节点左右子树拉平,再将右子树作为右节点拼接在左子树,并将原来的左子数作为新的右子树即可
     * 所以需要采用后序遍历,需要分别拉平左右子树之后再做拼接
     *
     * @param node
     */
    private void doFlatten(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1.拉平左子树
        doFlatten(node.left);
        // 2.拉平右子树
        doFlatten(node.right);
        // 3.拼接
        TreeNode rightTree = node.right;
        node.right = node.left;
        node.left = null;
        // 此处注意原右子树需要拼接在新右子树的最右边节点处
        TreeNode lastRightNode = findLastRightNode(node);
        lastRightNode.right = rightTree;
    }

    /**
     * 找到最右侧节点
     *
     * @param node
     * @return
     */
    private TreeNode findLastRightNode(TreeNode node) {
        TreeNode lastRightNode = node;
        while (lastRightNode.right != null) {
            lastRightNode = lastRightNode.right;
        }
        return lastRightNode;
    }

}