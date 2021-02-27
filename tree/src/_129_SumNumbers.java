/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _129_sumNumbers.java, v 0.1 2021年02月27日 12:02 PM wanhaofan
 */
public class _129_SumNumbers {

    int result = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return result;
    }

    private void traverse(TreeNode node, int pathSum){
        if(node == null){
            return;
        }
        pathSum = pathSum * 10 + node.val;
        if(node.left == null && node.right == null){
            result += pathSum;
        }
        traverse(node.left, pathSum);
        traverse(node.right, pathSum);
    }

}