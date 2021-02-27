/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _145_PostorderTraversal.java, v 0.1 2021年02月27日 12:23 PM wanhaofan
 */
public class _145_PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

}