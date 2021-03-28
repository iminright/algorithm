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
public class _894_AllPossibleFBT {


    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        if(n == 0){
            return nodes;
        }
        if(n % 2 != 1){
            return nodes;
        }
        if(n == 1){
            nodes.add(new TreeNode(0));
            return nodes;
        }

        int leftTreeSize = 1;
        int rightTreeSize = n - leftTreeSize - 1;

        while (rightTreeSize > 0){
            List<TreeNode> leftPossibleFBTList = allPossibleFBT(leftTreeSize);
            List<TreeNode> rightPossibleFBTList = allPossibleFBT(rightTreeSize);
            for (int i = 0; i < leftPossibleFBTList.size(); i++) {
                for (int j = 0; j < rightPossibleFBTList.size(); j++) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftPossibleFBTList.get(i);
                    root.right = rightPossibleFBTList.get(j);
                    nodes.add(root);
                }
            }
            leftTreeSize += 2;
            rightTreeSize = n - leftTreeSize - 1;
        }
        return nodes;
    }

    public static void main(String[] args) {
        _894_AllPossibleFBT main = new _894_AllPossibleFBT();
        main.allPossibleFBT(7);
    }



}