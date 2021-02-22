/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _226_ReverseTree.java, v 0.1 2021年02月14日 3:36 PM wanhaofan
 */
public class _226_InvertTree {

    /**
     * invert tree
     * base case: root == null?
     * invert: left <-> right
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * Thinking:
     * 1.前序和后序遍历都可以
     * 2.中序遍历需要稍做改进,因为在遍历右子树的时候右子树已经被调换了
     */

    /**
     * 中序遍历版本
     * invert tree
     * base case: root == null?
     * invert: left <-> right
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        return root;
    }

    /**
     * 后序遍历版本
     * invert tree
     * base case: root == null?
     * invert: left <-> right
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_3(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

}