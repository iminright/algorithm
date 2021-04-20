/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _95_GenerateTrees_1.java, v 0.1 2021Äê04ÔÂ20ÈÕ 10:27 PM wanhaofan
 */
public class _95_GenerateTrees_1 {

    public List<TreeNode> generateTrees(int n) {
        return doGenerate(1, n);
    }


    private List<TreeNode> doGenerate(int start, int end){
        if(start > end){
            return null;
        }
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = start; i <= end; i++) {

            List<TreeNode> leftNodes = doGenerate(start, i - 1);
            List<TreeNode> rightNodes = doGenerate(i + 1, end);
            if(leftNodes != null && rightNodes != null){
                for (int j = 0; j < leftNodes.size(); j++) {
                    for (int k = 0; k < rightNodes.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNodes.get(j);
                        root.right = rightNodes.get(k);
                        nodes.add(root);
                    }
                }
            }else if(rightNodes != null){
                for (int k = 0; k < rightNodes.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightNodes.get(k);
                    nodes.add(root);
                }
            }else if(leftNodes != null){
                for (int k = 0; k < leftNodes.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNodes.get(k);
                    nodes.add(root);
                }
            }else{
                TreeNode root = new TreeNode(i);
                nodes.add(root);
            }
        }
        return nodes;
    }

}