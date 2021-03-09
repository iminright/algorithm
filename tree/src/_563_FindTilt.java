/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _563_FindTilt.java, v 0.1 2021Äê03ÔÂ09ÈÕ 8:21 PM wanhaofan
 */
public class _563_FindTilt {
    


    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findTilt(root.left) + findTilt(root.right) + Math.abs(sum(root.left) - sum(root.right));
    }
    

    private int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        return sum(node.left) + sum(node.right) + node.val;
    }

}


