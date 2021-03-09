/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _563_FindTilt.java, v 0.1 2021Äê03ÔÂ09ÈÕ 8:21 PM wanhaofan
 */
public class _563_FindTilt_1 {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }
    

    private int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        tilt += Math.abs(leftSum -rightSum);
        return leftSum + rightSum + node.val;
    }

}


