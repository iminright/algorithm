/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _590_Postorder.java, v 0.1 2021Äê03ÔÂ11ÈÕ 3:13 PM wanhaofan
 */
public class _590_Postorder {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        doPostorder(root);
        return result;
    }

    private void doPostorder(Node node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.children.size(); i++) {
            doPostorder(node.children.get(i));
        }
        result.add(node.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;


}