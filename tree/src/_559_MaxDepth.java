/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.List;

/**
 * @author wanhaofan
 * @version _559_MaxDepth.java, v 0.1 2021Äê03ÔÂ09ÈÕ 8:12 PM wanhaofan
 */
public class _559_MaxDepth {

    public int maxDepth(Node root) {
        return getDepth(root);
    }

    private int getDepth(Node node){
        if(node == null){
            return 0;
        }
        if(node.children != null && node.children.size() > 0){
            int maxDepth = Integer.MIN_VALUE;
            for(Node child : node.children){
                int depth = getDepth(child);
                if(depth > maxDepth){
                    maxDepth = depth;
                }
            }
            return maxDepth + 1;
        }
        return 1;
    }

    class Node {
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

