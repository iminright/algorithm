/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _94_InorderTraversal.java, v 0.1 2021年02月16日 9:46 AM wanhaofan
 */
public class _94_InorderTraversal {
    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doInOrderTraversal(root, list);
        return list;
    }

    private void doInOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        doInOrderTraversal(node.left, list);
        list.add(node.val);
        doInOrderTraversal(node.right, list);
    }

}