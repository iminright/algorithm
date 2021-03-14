/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _687_LongestUnivaluePath.java, v 0.1 2021Äê03ÔÂ14ÈÕ 6:49 PM wanhaofan
 */
public class _687_LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(findLongest(root) , Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
    }

    private int findLongest(TreeNode node){
        if(node == null){
            return 0;
        }
        return findLongest2(node.left, node, 0) + findLongest2(node.right, node, 0);
    }

    private int findLongest2(TreeNode node, TreeNode parent, int path){
        if(node == null){
            return path;
        }
        if(parent.val != node.val){
            return path;
        }
        path++;
        return Math.max(findLongest2(node.left, node, path), findLongest2(node.right, node, path));
    }

    public static void main(String[] args) {
        TreeNode _5 = new TreeNode(5);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5_1 = new TreeNode(5);
        TreeNode _1 = new TreeNode(1);
        TreeNode _1_1 = new TreeNode(1);
        TreeNode _5_2 = new TreeNode(5);
        _5.left = _4;
        _5.right = _5_1;
        _4.left = _1;
        _4.right = _1_1;
        _5_1.right = _5_2;
        _687_LongestUnivaluePath main = new _687_LongestUnivaluePath();
        System.out.println(main.longestUnivaluePath(_5));
    }

}