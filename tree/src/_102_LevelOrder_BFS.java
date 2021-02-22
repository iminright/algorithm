/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.*;

/**
 * @author wanhaofan
 * @version _102_LevelOrder.java, v 0.1 2021年02月21日 1:01 PM wanhaofan
 */
public class _102_LevelOrder_BFS {


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(queue.peek() != null){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pop();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(list.size() > 0){
                result.add(list);
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _9 = new TreeNode(9);
        TreeNode _20 = new TreeNode(20);
        TreeNode _15 = new TreeNode(15);
        TreeNode _7 = new TreeNode(7);
        _3.left = _9;
        _3.right = _20;
        _20.left = _15;
        _20.right = _7;
        levelOrder(_3);
    }


}