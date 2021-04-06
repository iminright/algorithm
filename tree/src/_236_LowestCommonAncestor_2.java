/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _236_LowestCommonAncestor_1.java, v 0.1 2021年03月07日 11:47 PM wanhaofan
 */
public class _236_LowestCommonAncestor_2 {

    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p ,q);
        return result;
    }

    /**
     * p,q中是否至少一个在node为根节点的树中
     * @param node
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        boolean inLeft = dfs(node.left, p, q);
        boolean inRight = dfs(node.right, p, q);
        // 1.p/q分别在node节点的左右两边
        if(inLeft && inRight){
            result = node;
            return true;
        }
        // 2.p == node && q 在左边或者右边
        if(p.val == node.val && (inLeft || inRight)){
            result = p;
            return true;
        }
        // 3.q == node && p 在左边或者右边
        if(q.val == node.val && (inLeft || inRight)){
            result = q;
            return true;
        }
        // 4.p/q都在一边或者p/q都不在以node为根节点的树下面
        return inLeft || inRight || p.val == node.val || q.val == node.val;
    }



    public static void main(String[] args) {
        _236_LowestCommonAncestor_2 main = new _236_LowestCommonAncestor_2();
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
        main.lowestCommonAncestor(_3, _5, _4);
    }
}