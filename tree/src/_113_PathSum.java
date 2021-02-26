/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _113_PathSum.java, v 0.1 2021年02月26日 10:34 PM wanhaofan
 */
public class _113_PathSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preorder(root, new ArrayList<>(), 0, targetSum);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> list, int currentSum, int targetSum){
        if(node == null){
            return;
        }
        currentSum += node.val;
        list.add(node.val);
        if(node.right == null && node.left == null){
            if(currentSum == targetSum){
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        preorder(node.left, list, currentSum, targetSum);
        preorder(node.right, list, currentSum, targetSum);
        list.remove(list.size() - 1);
    }


}