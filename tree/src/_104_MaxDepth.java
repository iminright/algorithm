/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _104_MaxDepth.java, v 0.1 2021年02月22日 2:12 PM wanhaofan
 */
public class _104_MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // 树的最大深度 = Max(左子树最大深度, 右子树最大深度) + 1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}