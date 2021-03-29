/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _889_ConstructFromPrePost.java, v 0.1 2021年03月21日 10:12 PM wanhaofan
 */
public class _889_ConstructFromPrePost_1 {


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(0, pre.length - 1, pre, 0, post.length - 1, post);
    }

    private TreeNode buildTree(int preStart, int preEnd, int[] pre, int postStart, int postEnd, int[] post){
        if(preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int index = -1;
        for (int i = postStart; i < postEnd; i++) {
            if(post[i] == pre[preStart + 1]){
                index = i;
                break;
            }
        }
        //index是root.left在post中的位置,所以root左子树的大小是index - postStart + 1
        int leftSubTreeSize = index - postStart + 1;
        root.left = buildTree(preStart + 1, preStart + leftSubTreeSize, pre, postStart, index, post);
        root.right = buildTree(preStart + leftSubTreeSize + 1, preEnd, pre, index + 1, postEnd - 1, post);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[]{4,5,2,6,7,3,1};
        _889_ConstructFromPrePost_1 main = new _889_ConstructFromPrePost_1();
        TreeNode root = main.constructFromPrePost(pre, post);
        System.out.println(root);
    }

}