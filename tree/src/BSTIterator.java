/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version BSTIterator.java, v 0.1 2021年02月27日 12:25 PM wanhaofan
 */
public class BSTIterator {

    List<Integer> inorderList = new ArrayList<>();
    int inorderListIndex = 0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        inorderList.add(node.val);
        inorder(node.right);
    }

    public int next() {
        return inorderList.get(inorderListIndex++);
    }

    public boolean hasNext() {
        return inorderList.size() > inorderListIndex;
    }

}