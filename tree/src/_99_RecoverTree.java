/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _99_RecoverTree.java, v 0.1 2021年02月16日 6:54 PM wanhaofan
 */
public class _99_RecoverTree {

    static TreeNode prev;

    public static void recoverTree(TreeNode root) {
        while(!doRecover(root)){

        }
    }

    private static boolean doRecover(TreeNode node){
        if(node == null){
            return true;
        }
        if(!doRecover(node.left)){
            return false;
        }
        if(prev != null && prev.val > node.val){
            int temp = prev.val;
            prev.val = node.val;
            node.val = temp;
            return false;
        }
        prev = node;
        if(!doRecover(node.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        _1.left = _3;
        _3.right = _2;
        recoverTree(_1);
        System.out.println(_1);
    }

}