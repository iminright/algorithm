/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _501_FindMode.java, v 0.1 2021年03月06日 3:51 PM wanhaofan
 */
public class _501_FindMode {

    int maxCount = 0;
    int currentCount = 0;
    int pre;
    List<Integer> mostCountNodeVal = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        pre = root.val;
        traverse(root);
        int[] res = new int[mostCountNodeVal.size()];
        for (int i = 0; i < mostCountNodeVal.size(); i++) {
            res[i] = mostCountNodeVal.get(i);
        }
        return res;
    }

    private void traverse(TreeNode node){
        if(node == null){
            return;
        }
        // BST中序遍历是有序的
        traverse(node.left);
        update(node);
        traverse(node.right);
    }

    private void update(TreeNode node){
        if(node.val == pre){
            currentCount++;
        }else{
            currentCount = 1;
            pre = node.val;
        }
        if(currentCount == maxCount){
            mostCountNodeVal.add(node.val);
        }else if(currentCount > maxCount){
            mostCountNodeVal.clear();
            mostCountNodeVal.add(node.val);
            maxCount = currentCount;
        }

    }

}