/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _653_FindTarget.java, v 0.1 2021Äê03ÔÂ11ÈÕ 8:46 PM wanhaofan
 */
public class _653_FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        for (int i = 0; i < list.size(); i++) {
            if(findTarget2(root, k - list.get(i).val, list.get(i))){
                return true;
            }
        }
        return false;
    }

    private void traverse(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        list.add(node);
        traverse(node.left, list);
        traverse(node.right, list);
    }

    private boolean findTarget2(TreeNode node, int k, TreeNode exclude){
        if(node == null){
            return false;
        }
        if(node.val < k){
            return findTarget2(node.right, k, exclude);
        }else if(node.val > k){
            return findTarget2(node.left, k, exclude);
        }else{
            if(exclude == node){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        _2.left = _1;
        _2.right = _3;
        _653_FindTarget main = new _653_FindTarget();
        System.out.println(main.findTarget(_2, 4));
    }

}