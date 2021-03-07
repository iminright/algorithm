/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _450_DeleteNode.java, v 0.1 2021��03��06�� 3:17 PM wanhaofan
 */
public class _450_DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.left = root;
        doDeleteNode(root, dummyNode, true, key);
        if (root != null && root.val == key) {
            return root.right == null ? root.left : root.right;
        } else {
            return root;
        }
    }

    private void doDeleteNode(TreeNode node, TreeNode parent, boolean childIsLeft, int key) {
        if (node == null) {
            return;
        }
        if (node.val == key) {
            //�ҵ���Ҫɾ���Ľڵ�
            if (childIsLeft) {
                //��ɾ��������ڵ�
                if (node.right == null) {
                    parent.left = node.left;
                } else {
                    parent.left = node.right;
                    TreeNode mostLeftNode = findMostLeft(node.right);
                    mostLeftNode.left = node.left;
                }
            } else {
                //��ɾ�������ҽڵ�
                if (node.right == null) {
                    parent.right = node.left;
                } else {
                    parent.right = node.right;
                    TreeNode mostLeftNode = findMostLeft(node.right);
                    mostLeftNode.left = node.left;
                }
            }
            return;
        } else if (node.val > key) {
            doDeleteNode(node.left, node, true, key);
        } else {
            doDeleteNode(node.right, node, false, key);
        }

    }

    private TreeNode findMostLeft(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return findMostLeft(node.left);
    }


}