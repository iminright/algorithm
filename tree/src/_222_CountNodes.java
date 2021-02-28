/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _222_CountNodes.java, v 0.1 2021年02月28日 10:52 AM wanhaofan
 */
public class _222_CountNodes {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}