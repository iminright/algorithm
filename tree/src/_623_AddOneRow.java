/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _623_AddOneRow.java, v 0.1 2021Äê03ÔÂ11ÈÕ 3:57 PM wanhaofan
 */
public class _623_AddOneRow {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null){
            return null;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 1;
        List<TreeNode> d_1NodeList = new ArrayList<>();
        while (queue.peek() != null){
            if(depth > d - 1){
                break;
            }
            int size = queue.size();
            List<TreeNode> levelNode = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pop();
                levelNode.add(node);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            d_1NodeList = levelNode;
            depth++;
        }
        if(d_1NodeList.size() == 0){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        for (int i = 0; i < d_1NodeList.size(); i++) {
            TreeNode node = d_1NodeList.get(i);
            addRow2Node(node, v);
        }
        return root;
    }

    private void addRow2Node(TreeNode node, int v){
        TreeNode originLeft = node.left;
        TreeNode originRight = node.right;
        node.left = new TreeNode(v);
        node.right = new TreeNode(v);
        node.left.left = originLeft;
        node.right.right = originRight;
    }

    public static void main(String[] args) {
        _623_AddOneRow main = new _623_AddOneRow();
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        _1.left = _2;
        _1.right = _3;
        _3.left = _4;
        main.addOneRow(_1, 5, 4);
    }

}