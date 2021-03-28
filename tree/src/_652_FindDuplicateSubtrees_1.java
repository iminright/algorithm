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
 * @version _652_FindDuplicateSubtrees_1.java, v 0.1 2021年03月28日 10:54 AM wanhaofan
 */
public class _652_FindDuplicateSubtrees_1 {

    List<TreeNode> duplicateNodes = new ArrayList<>();
    Map<String, Integer> countMap = new HashMap();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return duplicateNodes;
    }


    private String traverse(TreeNode node){
        if(node == null){
            return "#";
        }
        // 使用后序遍历描述自身
        String nodeDeserialize = traverse(node.left) + "," + traverse(node.right) + "," + node.val;
        int count = countMap.getOrDefault(nodeDeserialize, 0);
        if(count + 1 == 2){
            duplicateNodes.add(node);
        }else{
            countMap.put(nodeDeserialize, count + 1);
        }
        return nodeDeserialize;
    }



}