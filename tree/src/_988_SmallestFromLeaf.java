/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.*;

/**
 * @author wanhaofan
 * @version _988_SmallestFromLeaf.java, v 0.1 2021Äê04ÔÂ05ÈÕ 3:30 PM wanhaofan
 */
public class _988_SmallestFromLeaf {

    ArrayDeque<Integer> smallestPath;

    char[] azArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new ArrayDeque<>());
        StringBuilder sb = new StringBuilder();
        while (smallestPath.peek() != null){
            int val = smallestPath.pop();
            sb.append(azArray[val]);
        }
        return sb.toString();
    }

    private void dfs(TreeNode node, ArrayDeque<Integer> queue){
        if(node == null){
            return;
        }
        queue.addFirst(node.val);
        if(node.left == null && node.right == null){
            if(smallestPath == null){
                smallestPath = new ArrayDeque<>(queue);
            }else{
                if(comparePath(smallestPath, queue) > 0){
                    smallestPath = new ArrayDeque<>(queue);
                }
            }
        }else{
            dfs(node.left, queue);
            dfs(node.right, queue);
        }
        queue.pop();
    }

    private int comparePath(ArrayDeque<Integer> q1, ArrayDeque<Integer> q2){
        Iterator<Integer> q1Iter = q1.iterator();
        Iterator<Integer> q2Iter = q2.iterator();
        while (q1Iter.hasNext() && q2Iter.hasNext()){
            int q1val = q1Iter.next();
            int q2val = q2Iter.next();
            if(q1val < q2val){
                return -1;
            }else if(q1val > q2val){
                return 1;
            }
        }
        if(q1Iter.hasNext()){
            return 1;
        }
        if(q2Iter.hasNext()){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode _0 = new TreeNode(0);
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _3_1 = new TreeNode(3);
        TreeNode _4_1 = new TreeNode(4);
        _0.left = _1;
        _0.right = _2;
        _1.left = _3;
        _1.right = _4;
        _2.left = _3_1;
        _2.right = _4_1;
        _988_SmallestFromLeaf main = new _988_SmallestFromLeaf();
        main.smallestFromLeaf(_0);

    }


}