/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version GOLD04_ListOfDepthLcci.java, v 0.1 2021年02月24日 8:58 PM wanhaofan
 */
public class GOLD04_ListOfDepthLcci {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[]{};
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        List<ListNode> result = new ArrayList<>();
        while (queue.peek() != null) {
            int size = queue.size();
            ListNode prevNode = null;
            ListNode firstNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                ListNode listNode = new ListNode(node.val);
                if (prevNode != null) {
                    prevNode.next = listNode;
                }
                if (firstNode == null) {
                    firstNode = listNode;
                }
                prevNode = listNode;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(firstNode);
        }
        return result.toArray(new ListNode[result.size()]);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}