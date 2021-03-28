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
public class _919_CBTInserter {

    private TreeNode root;

    private Queue<TreeNode> insertParent = new LinkedList<>();

    public _919_CBTInserter(TreeNode root) {
        traverse(root);
        this.root = root;
    }

    public int insert(int v) {
        TreeNode parent = insertParent.peek();
        TreeNode node = new TreeNode(v);
        insertParent.add(node);
        if(parent.left == null){
            parent.left = node;
        }else{
            parent.right = node;
            insertParent.poll();
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.peek() != null){
            TreeNode node = queue.pop();
            if(node.left == null || node.right == null){
                insertParent.add(node);
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