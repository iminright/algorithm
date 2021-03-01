/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _257_BinaryTreePaths.java, v 0.1 2021年03月01日 8:51 PM wanhaofan
 */
public class _257_BinaryTreePaths {

    static String path = "";

    static List<String> list = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return list;
        }
        inorderTraversal(root);
        return list;
    }

    private static void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        String originPath = path;
        path += node.val + "->";
        if(node.left == null && node.right == null){
            path = path.substring(0, path.length() - 2);
            list.add(path);
        }else{
            inorderTraversal(node.left);
            inorderTraversal(node.right);
        }
        path = originPath;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _5 = new TreeNode(5);

        _1.left = _2;
        _1.right = _3;
        _2.right = _5;

        binaryTreePaths(_1);
        System.out.println("1");
    }

}