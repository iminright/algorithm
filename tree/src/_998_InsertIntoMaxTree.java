/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _998_InsertIntoMaxTree.java, v 0.1 2021��04��05�� 4:16 PM wanhaofan
 */
public class _998_InsertIntoMaxTree {

    TreeNode ans;

    //�����������ĩβ��ʾֻ��������������Ҳֻ������root���Ѿ�����������������
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
            // �ҵ��˲����λ��
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