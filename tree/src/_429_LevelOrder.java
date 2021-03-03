/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _429_LevelOrder.java, v 0.1 2021年03月03日 8:45 PM wanhaofan
 */
public class _429_LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.peek() != null){
            int size = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node parent = queue.pop();
                currentLevelList.add(parent.val);
                for(Node child : parent.children){
                    queue.add(child);
                }
            }
            result.add(currentLevelList);
        }
        return result;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}

