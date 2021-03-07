/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _236_LowestCommonAncestor_1.java, v 0.1 2021��03��07�� 11:47 PM wanhaofan
 */
public class _236_LowestCommonAncestor_1 {

    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p ,q);
        return result;
    }

    /**
     * �ж� p,q ���Ƿ�������һ������nodeΪ���ڵ��������
     * @param node
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        boolean inLeft = dfs(node.left, p ,q);
        boolean inRight = dfs(node.right, p ,q);
        if(inLeft && inRight){
            // p,q��node����������һ��,��node��LCA
            result = node;
            return true;
        }
        if(p.val == node.val && (inLeft || inRight)){
            // ���p����node,����q��node������������������node��LCA
            result = node;
            return true;
        }
        if(q.val == node.val && (inLeft || inRight)){
            // ���q����node,����p��node������������������node��LCA
            result = node;
            return true;
        }
        // �������������������p==node����q==node ��ô˵��p,q��������һ����nodeΪ���ڵ��������
        return inLeft || inRight || node.val == p.val || node.val == q.val;
    }

    public static void main(String[] args) {
        _236_LowestCommonAncestor_1 main = new _236_LowestCommonAncestor_1();
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