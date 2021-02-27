/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _117_Connect.java, v 0.1 2021年02月27日 11:19 AM wanhaofan
 */
public class _117_Connect {

    public Node connect(Node root) {
        doConnect(root);
        return root;
    }

    private void doConnect(Node node){
        if(node == null){
            return;
        }
        if(node.left != null){
            node.left.next = node.right;
        }
        if(node.right != null){
            node.right.next = findSiblingMostLeftNode(node);
        }else{
            if(node.left != null){
                node.left.next = findSiblingMostLeftNode(node);
            }
        }
        // 这里是最tricky的地方, 需要先把右子树子节点间的关系建立起来, 不然 findSiblingMostLeftNode 方法会返回错误的结果
        connect(node.right);
        connect(node.left);
    }

    private Node findSiblingMostLeftNode(Node node){
        while(node.next != null){
            if(node.next.left != null){
                return node.next.left;
            }
            if(node.next.right != null){
                return node.next.right;
            }
            node = node.next;
        }
        return null;
    }



}