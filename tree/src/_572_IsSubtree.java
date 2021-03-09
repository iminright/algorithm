/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _572_IsSubtree.java, v 0.1 2021Äê03ÔÂ09ÈÕ 8:55 PM wanhaofan
 */
public class _572_IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean traverse(TreeNode s, TreeNode t){
        if(isSame(s, t)){
            return true;
        }
        if(s == null){
            return false;
        }
        return traverse(s.left, t) || traverse(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }else if(s != null && t != null){
            return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
        }else{
            return false;
        }
    }

}