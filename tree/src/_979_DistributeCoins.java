/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _979_DistributeCoins.java, v 0.1 2021Äê03ÔÂ31ÈÕ 10:00 PM wanhaofan
 */
public class _979_DistributeCoins {

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        if(postorder(root) == 0){
            return ans;
        }
        return -1;
    }

    private int postorder(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = postorder(node.left);
        int right = postorder(node.right);
        ans += Math.abs(left) + Math.abs(right);
        return left + right + node.val - 1;
    }

}