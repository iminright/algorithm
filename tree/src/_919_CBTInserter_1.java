/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wanhaofan
 * @version _919_CBTInserter.java, v 0.1 2021Äê03ÔÂ28ÈÕ 3:30 PM wanhaofan
 */
public class _919_CBTInserter_1 {

    TreeNode root = null;

    ArrayDeque<TreeNode> queue4Insert = new ArrayDeque<>();

    public _919_CBTInserter_1(TreeNode root) {
        if(root != null){
            traverse(root);
            this.root = root;
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        queue4Insert.add(node);
        TreeNode firstNode = queue4Insert.peek();
        if(firstNode.left == null){
            firstNode.left = node;
        }else{
            firstNode.right = node;
            queue4Insert.pop();
        }
        return firstNode.val;
    }

    public TreeNode get_root() {
        return root;
    }

    private void traverse(TreeNode root){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.peek() != null){
            TreeNode node = queue.pop();
            if(node.left == null || node.right == null){
                queue4Insert.add(node);
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

}