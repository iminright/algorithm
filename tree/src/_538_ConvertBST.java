/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _538_ConvertBST.java, v 0.1 2021年03月07日 9:01 PM wanhaofan
 */
public class _538_ConvertBST {
    /**
     * 考虑每个node需要干什么
     * 考虑遍历的方法前序/中序/后序/中反序等...
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        return root;
    }

    private int traverse(TreeNode node, int acc) {
        if (node == null) {
            return acc;
        }
        int rightSum = traverse(node.right, acc);
        node.val = rightSum + node.val;
        return traverse(node.left, node.val);
    }

}