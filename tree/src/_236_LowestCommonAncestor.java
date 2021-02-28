/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wanhaofan
 * @version _236_LowestCommonAncestor.java, v 0.1 2021年02月28日 11:55 AM wanhaofan
 */
public class _236_LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p_path = new ArrayList<>();
        List<TreeNode> q_path = new ArrayList<>();
        findNode(root, p, p_path);
        findNode(root, q, q_path);
        int minDepth = Math.min(p_path.size(), q_path.size());
        for (int i = minDepth - 1; i >= 0; i--) {
            if(p_path.get(i).val == q_path.get(i).val){
                return p_path.get(i);
            }
        }
        return null;
    }

    private static boolean findNode(TreeNode root, TreeNode node, List<TreeNode> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(node.val == root.val){
            return true;
        }
        if(!findNode(root.left, node, path)){
            if(!findNode(root.right, node, path)){
                path.remove(path.size() - 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _5 = new TreeNode(5);
        TreeNode _1 = new TreeNode(1);
        TreeNode _6 = new TreeNode(6);
        TreeNode _2 = new TreeNode(2);
        TreeNode _0 = new TreeNode(0);
        TreeNode _8 = new TreeNode(8);
        TreeNode _7 = new TreeNode(7);
        TreeNode _4 = new TreeNode(4);

        _3.left = _5;
        _3.right = _1;
        _5.left = _6;
        _5.right = _2;
        _2.left = _7;
        _2.right = _4;
        _1.left = _0;
        _1.right = _8;
        lowestCommonAncestor(_3, _5, _4);
    }

}