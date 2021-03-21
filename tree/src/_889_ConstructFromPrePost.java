/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _889_ConstructFromPrePost.java, v 0.1 2021Äê03ÔÂ21ÈÕ 10:12 PM wanhaofan
 */
public class _889_ConstructFromPrePost {

    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(0, pre.length - 1, pre, post);
    }

    private TreeNode buildTree(int startInPost, int endInPost, int[] pre, int[] post){
        if(preIndex >= pre.length || startInPost > endInPost){
            return null;
        }
        if(startInPost == endInPost){
            return new TreeNode(post[startInPost]);
        }
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;
        if(preIndex >= pre.length){
            return root;
        }
        for(int i = startInPost; i <= endInPost; i++){
            if(post[i] == pre[preIndex]){
                root.left = buildTree(startInPost, i - 1 < startInPost ? startInPost : (i - 1), pre, post);
                if(root.left != null){
                    preIndex++;
                }
                root.right = buildTree(i + 1 > endInPost ? endInPost : (i + 1), endInPost, pre, post);
                break;
            }
        }
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