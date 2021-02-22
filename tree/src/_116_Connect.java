/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _116_Connect.java, v 0.1 2021年02月14日 4:41 PM wanhaofan
 */
public class _116_Connect {

    public Node connect(Node root) {
        doConnect(root, null);
        return root;
    }

    /**
     * 按照前序遍历访问整颗树
     *
     * @param node             当前节点
     * @param rightSiblingNode 当前节点的右侧节点
     */
    public void doConnect(Node node, Node rightSiblingNode) {
        if (node == null) {
            return;
        }
        // 1.将当前节点的next指向右侧节点
        node.next = rightSiblingNode;
        // 因为是完美平衡二叉树所以只判断left不为空即可
        if (node.left != null) {
            // 2.链接同一个父节点的左右节点
            doConnect(node.left, node.right);
            // 3.链接右节点和该节点的右侧节点
            doConnect(node.right, findRightSiblingNode(node));
        }
    }

    /**
     * 找到node.right节点的右侧节点
     *
     * @param node
     * @return
     */
    public Node findRightSiblingNode(Node node) {
        if (node.next != null) {
            // 因为采用的前序遍历,父节点间的链接已经建立完毕,可以靠next指针找到目标Node
            return node.next.left;
        }
        return null;
    }

}