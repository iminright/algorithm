/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _894_AllPossibleFBT.java, v 0.1 2021Äê03ÔÂ28ÈÕ 11:35 AM wanhaofan
 */
public class _894_AllPossibleFBT_1 {


    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> allPossibleFBTList = new ArrayList<>();
        if(n % 2 == 0){
            return allPossibleFBTList;
        }
        if(n == 1){
            TreeNode root = new TreeNode(0);
            allPossibleFBTList.add(root);
            return allPossibleFBTList;
        }
        int leftTreeSize = 1;
        int rightTreeSize = n - 1 - leftTreeSize;
        while (rightTreeSize >= 1){
            List<TreeNode> leftAllPossibleFBTList = allPossibleFBT(leftTreeSize);
            List<TreeNode> rightAllPossibleFBTList = allPossibleFBT(rightTreeSize);

            for (int i = 0; i < leftAllPossibleFBTList.size(); i++) {
                for (int j = 0; j < rightAllPossibleFBTList.size(); j++) {
                    TreeNode node = new TreeNode();
                    node.left = leftAllPossibleFBTList.get(i);
                    node.right = rightAllPossibleFBTList.get(j);
                    allPossibleFBTList.add(node);
                }
            }
            leftTreeSize += 2;
            rightTreeSize -= 2;
        }
        return allPossibleFBTList;
    }

    public static void main(String[] args) {
        _894_AllPossibleFBT_1 main = new _894_AllPossibleFBT_1();
        main.allPossibleFBT(7);
    }



}