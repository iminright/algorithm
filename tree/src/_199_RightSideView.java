/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _199_RightSideView.java, v 0.1 2021年02月28日 10:30 AM wanhaofan
 */
public class _199_RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        while (queue.peek() != null) {
            int size = queue.size();
            int j = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (i == j) {
                    if (node.right != null) {
                        result.add(node.right.val);
                    } else if (node.left != null) {
                        result.add(node.left.val);
                    } else{
                        j++;
                    }
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return result;
    }

}