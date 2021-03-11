/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wanhaofan
 * @version _652_FindDuplicateSubtrees.java, v 0.1 2021Äê03ÔÂ11ÈÕ 5:02 PM wanhaofan
 */
public class _652_FindDuplicateSubtrees {

    List<TreeNode> nodes = new ArrayList<>();
    List<TreeNode> duplicateNodes = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        for (int i = 0; i < nodes.size(); i++) {
            for(int j = i + 1; j < nodes.size(); j++){
                if(nodes.get(i) != null && nodes.get(j) != null && isSame(nodes.get(i), nodes.get(j))){
                    boolean needAdd = true;
                    for (int k = 0; k < duplicateNodes.size(); k++) {
                        if(isSame(duplicateNodes.get(k), nodes.get(i))){
                            needAdd = false;
                            break;
                        }
                    }
                    if(needAdd){
                        duplicateNodes.add(nodes.get(i));
                        nodes.set(i, null);
                        nodes.set(j, null);
                    }
                }
            }
        }
        return duplicateNodes;
    }

    private void traverse(TreeNode node){
        if(node == null){
            return;
        }
        nodes.add(node);
        traverse(node.left);
        traverse(node.right);
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            return node1.val == node2.val && isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        }
        return false;
    }

}