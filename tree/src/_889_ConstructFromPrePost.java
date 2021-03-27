/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _889_ConstructFromPrePost.java, v 0.1 2021年03月21日 10:12 PM wanhaofan
 */
public class _889_ConstructFromPrePost {


    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return buildTree(0, pre.length - 1, pre, 0, post.length - 1, post);
    }

    private TreeNode buildTree(int preStart, int preEnd, int[] pre, int postStart, int postEnd, int[] post){
        if(preEnd < preStart || postEnd < postStart){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd){
            return root;
        }
        // index 区分左右子树的分界点
        if(preStart + 1 >= pre.length){
            return root;
        }
        int index = -1;
        for (int i = postStart; i <= postEnd; i++) {
            if(post[i] == pre[preStart + 1]){
                index = i;
                break;
            }
        }

        root.left = buildTree(preStart + 1, preStart + 1 + index - postStart, pre, postStart, index, post);
        // 主要注意right tree的起始位置,rightTreePreStart = leftTreePreEnd + 1
        root.right = buildTree(preStart + 1 + index - postStart + 1, preEnd, pre,index + 1, postEnd - 1, post);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[]{4,5,2,6,7,3,1};
        _889_ConstructFromPrePost main = new _889_ConstructFromPrePost();
        TreeNode root = main.constructFromPrePost(pre, post);
        System.out.println(root);
    }

}