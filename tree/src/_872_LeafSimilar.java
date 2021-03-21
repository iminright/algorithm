/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _872_LeafSimilar.java, v 0.1 2021Äê03ÔÂ21ÈÕ 10:07 PM wanhaofan
 */
public class _872_LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaf(root1, leaves1);
        getLeaf(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaf(TreeNode node, List<Integer> leaf){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            leaf.add(node.val);
        }
        getLeaf(node.left, leaf);
        getLeaf(node.right, leaf);
    }

}