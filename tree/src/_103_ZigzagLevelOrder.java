/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wanhaofan
 * @version _103_ZigzagLevelOrder.java, v 0.1 2021年02月22日 1:40 PM wanhaofan
 */
public class _103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (queue.peek() != null){
            int size = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                currentLevelList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(level % 2 == 1){
                // reverse the currentLevelList
                Collections.reverse(currentLevelList);
            }
            result.add(currentLevelList);
            level++;
        }
        return result;
    }

}