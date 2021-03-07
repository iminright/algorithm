/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;

/**
 * @author wanhaofan
 * @version _513_FindBottomLeftValue.java, v 0.1 2021Äê03ÔÂ07ÈÕ 5:40 PM wanhaofan
 */
public class _513_FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.peek() != null){
            int size = queue.size();
            TreeNode firstNodeInCurrentLevel = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if(i == 0){
                    firstNodeInCurrentLevel = node;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(queue.size() == 0){
                return firstNodeInCurrentLevel.val;
            }
        }
        // can't reach here
        return 333;
    }


}