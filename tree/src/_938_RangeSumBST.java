/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _938_RangeSumBST.java, v 0.1 2021Äê03ÔÂ28ÈÕ 4:31 PM wanhaofan
 */
public class _938_RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum = root.val;
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + sum;
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return rangeSumBST(root.right, low, high);
        }
    }


}