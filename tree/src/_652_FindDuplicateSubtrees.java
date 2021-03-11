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
 * @version _652_FindDuplicateSubtrees.java, v 0.1 2021��03��11�� 5:02 PM wanhaofan
 */
public class _652_FindDuplicateSubtrees {

    List<TreeNode> duplicateNodes = new ArrayList<>();

    Map<String, Integer> countMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return duplicateNodes;
    }

    private String traverse(TreeNode node){
        if(node == null){
            return "#";
        }
        //���ﲻ�����������������Ϊ�������û�취�����������
        //  0   0
        // /     \
        //0       0
        //���߶��� #0#0#,��������һЩ���л��Ĳ���ʱ����ʹ��pre/postorder
        String serial = node.val + "," + traverse(node.left)  + traverse(node.right);
        int count = countMap.getOrDefault(serial, 0);
        countMap.put(serial, count + 1);
        if(count + 1 == 2){
            duplicateNodes.add(node);
        }
        return serial;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(0);
        n1.left = n2;
        n2.left = n3;
        n1.right = n4;
        n4.right = n5;
        n5.right = n6;
        _652_FindDuplicateSubtrees main = new _652_FindDuplicateSubtrees();
        main.findDuplicateSubtrees(n1);
    }

}