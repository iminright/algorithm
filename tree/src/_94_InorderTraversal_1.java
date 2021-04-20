/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _94_InorderTraversal_1.java, v 0.1 2021Äê04ÔÂ20ÈÕ 10:24 PM wanhaofan
 */
public class _94_InorderTraversal_1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

}