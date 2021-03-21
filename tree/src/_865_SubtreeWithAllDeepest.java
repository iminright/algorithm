/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _865_SubtreeWithAllDeepest.java, v 0.1 2021��03��21�� 9:10 PM wanhaofan
 */
public class _865_SubtreeWithAllDeepest {

    int deepestDepth = 0;

    Map<Integer, List<TreeNode>> depthNodeMap = new HashMap<>();

    TreeNode result;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null){
            return null;
        }
        findDeepestDepth(root, 0);
        List<TreeNode> deepestNodes = depthNodeMap.get(deepestDepth);
        if(deepestNodes.size() == 1){
            return deepestNodes.get(0);
        }
        //������������ϵ�����ڵ�, ��Ѱ�����ǵĹ�������
        presentInSubTree(root, deepestNodes);
        return result;
    }

    private boolean presentInSubTree(TreeNode node, List<TreeNode> deepestNodes){
        if(node == null){
            return false;
        }
        //������һ��node�����
        boolean presentInLeftTree = presentInSubTree(node.left, deepestNodes);
        //������һ��node���ұ�
        boolean presentInRightTree = presentInSubTree(node.right, deepestNodes);
        if(presentInLeftTree && presentInRightTree){
            result = node;
            return true;
        }
        boolean currentNodeDeepest = deepestNodes.contains(node);
        if(currentNodeDeepest && (presentInLeftTree || presentInRightTree)){
            result = node;
            return true;
        }
        return currentNodeDeepest || presentInRightTree || presentInLeftTree;
    }

    private void findDeepestDepth(TreeNode node, int depth){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(depthNodeMap.containsKey(depth)){
                depthNodeMap.get(depth).add(node);
            }else{
                List<TreeNode> list = new ArrayList<>();
                list.add(node);
                depthNodeMap.put(depth, list);
            }
            deepestDepth = deepestDepth > depth ? deepestDepth : depth;
        }
        findDeepestDepth(node.left, depth + 1);
        findDeepestDepth(node.right, depth + 1);
    }


}