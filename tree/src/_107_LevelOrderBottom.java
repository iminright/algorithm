/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _107_LevelOrderBottom.java, v 0.1 2021年02月23日 5:08 PM wanhaofan
 */
public class _107_LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.peek() != null) {
            int size = queue.size();
            List<Integer> valList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                valList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.offerFirst(valList);
        }
        return result;
    }

}