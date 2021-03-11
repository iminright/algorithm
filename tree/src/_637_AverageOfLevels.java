/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _637_AverageOfLevels.java, v 0.1 2021Äê03ÔÂ11ÈÕ 4:57 PM wanhaofan
 */
public class _637_AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Double> result = new ArrayList<>();
        while (queue.peek() != null){
            int size = queue.size();
            Double sum = 0d;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                sum += node.val;
            }
            result.add(sum / size);
        }
        return result;
    }

}