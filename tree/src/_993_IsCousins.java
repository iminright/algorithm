/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _993_IsCousins.java, v 0.1 2021Äê04ÔÂ05ÈÕ 4:06 PM wanhaofan
 */
public class _993_IsCousins {

    int XX_depth,YY_depth;
    TreeNode xparent;
    TreeNode yparent;
    int helper = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return XX_depth == YY_depth && xparent != yparent;
    }

    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y){
        if(node == null){
            return;
        }
        if(node.val == x){
            xparent = parent;
            XX_depth = depth;
            helper++;
        }
        if(node.val == y){
            yparent = parent;
            YY_depth = depth;
            helper++;
        }
        if(helper == 2){
            return;
        }
        dfs(node.left,  node, depth+1, x, y);
        dfs(node.right, node, depth+1, x, y);
    }

}