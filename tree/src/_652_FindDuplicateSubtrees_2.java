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
public class _652_FindDuplicateSubtrees_2 {

    List<TreeNode> duplicateNodes = new ArrayList<>();
    Map<String, Integer> countMap = new HashMap<>();

    /**
     * 序列化每一颗树,借助map存储
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return duplicateNodes;
    }

    private String traverse(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String serial = traverse(node.left) + "," + traverse(node.right) + "," + node.val;
        int encounterNO = countMap.getOrDefault(serial, 0);
        countMap.put(serial, encounterNO + 1);
        if (encounterNO + 1 == 2) {
            duplicateNodes.add(node);
        }
        return serial;
    }

}