/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _998_InsertIntoMaxTree.java, v 0.1 2021年04月05日 4:16 PM wanhaofan
 */
public class _998_InsertIntoMaxTree {

    TreeNode ans;

    //增加在数组的末尾表示只可能有左子树，也只可能是root中已经存在子树的右子树
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        ans = root;
        dfs(root, null, val);
        return ans;
    }

    private void dfs(TreeNode node, TreeNode parent, int val){
        if(node == null){
            return;
        }
        if(node.val > val){
            if(node.right == null){
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
            }else{
                dfs(node.right, node, val);
            }
        }else if(node.val < val){
            TreeNode newNode = new TreeNode(val);
            // 找到了插入的位置
            if(parent != null){
                parent.right = newNode;
                newNode.left = node;
                return;
            }else{
                newNode.left = node;
                ans = newNode;
                return;
            }
        }
    }


}