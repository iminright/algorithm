/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _589_Preorder.java, v 0.1 2021年02月24日 9:17 PM wanhaofan
 */
public class _589_Preorder {

    public List<Integer> preorder(NXNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        return result;
    }

    private void traverse(NXNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (NXNode child : node.children) {
            traverse(child, result);
        }
    }

}

class NXNode {
    public int val;
    public List<NXNode> children;

    public NXNode() {
    }

    public NXNode(int _val) {
        val = _val;
    }

    public NXNode(int _val, List<NXNode> _children) {
        val = _val;
        children = _children;
    }
};