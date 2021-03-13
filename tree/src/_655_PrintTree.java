/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _655_PrintTree.java, v 0.1 2021Äê03ÔÂ13ÈÕ 9:07 AM wanhaofan
 */
public class _655_PrintTree {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> treeList = new ArrayList<>();
        if (root == null) {
            return treeList;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (queue.peek() != null) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int fullNodeSize = Double.valueOf(Math.pow(2, depth)).intValue() - 1;
        for (int i = 0; i < depth; i++) {
            List<String> list = new ArrayList<>(fullNodeSize);
            for (int j = 0; j < fullNodeSize; j++) {
                list.add("");
            }
            treeList.add(list);
        }
        traverse(root, 0, treeList.get(0).size() - 1, 1, treeList);
        return treeList;
    }

    private void traverse(TreeNode node, int start, int end, int currentDepth, List<List<String>> treeList){
        if(node == null){
            return;
        }
        int mid = (start + end) / 2;
        treeList.get(currentDepth - 1).set(mid, node.val + "");
        traverse(node.left, start, mid - 1, currentDepth + 1, treeList);
        traverse(node.right, mid + 1, end, currentDepth + 1, treeList);
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        _1.left = _2;
        _1.right = _3;
        _2.right = _4;
        _655_PrintTree main = new _655_PrintTree();
        main.printTree(_1);
    }



}