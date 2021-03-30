/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _951_FlipEquiv.java, v 0.1 2021Äê03ÔÂ30ÈÕ 9:58 PM wanhaofan
 */
public class _951_FlipEquiv {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null && root1.val == root2.val) {
            if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
                return true;
            } else {
                TreeNode temp = root1.right;
                root1.right = root1.left;
                root1.left = temp;
                return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            }
        } else {
            return false;
        }
    }

}