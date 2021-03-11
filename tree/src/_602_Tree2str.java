/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _602_Tree2str.java, v 0.1 2021Äê03ÔÂ11ÈÕ 3:23 PM wanhaofan
 */
public class _602_Tree2str {

    StringBuilder str = new StringBuilder();

    public String tree2str(TreeNode t) {
        preorder(t);
        return str.toString();
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        str.append(node.val);
        if (node.left != null) {
            str.append("(");
            preorder(node.left);
            str.append(")");
        } else {
            if (node.right != null) {
                str.append("()");
            }
        }
        if (node.right != null) {
            str.append("(");
            preorder(node.right);
            str.append(")");
        }
    }
}