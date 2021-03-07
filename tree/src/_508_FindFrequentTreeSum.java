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
 * @version _508_FindFrequentTreeSum.java, v 0.1 2021Äê03ÔÂ07ÈÕ 5:15 PM wanhaofan
 */
public class _508_FindFrequentTreeSum {

    Map<Integer, Integer> memo = new HashMap<>();

    int mostFrequentTimes = 0;

    List<Integer> treeSumList = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sumTree(root);
        int[] res = new int[treeSumList.size()];
        for (int i = 0; i < treeSumList.size(); i++) {
            res[i] = treeSumList.get(i);
        }
        return res;
    }

    private Integer sumTree(TreeNode node){
        if(node == null){
            return null;
        }
        Integer leftSum = sumTree(node.left);
        Integer rightSum = sumTree(node.right);
        Integer rootSum = (leftSum == null ? 0 : leftSum) + (rightSum == null ? 0 : rightSum) + node.val;
        update(rootSum);
        return rootSum;
    }

    private void update(Integer treeSum){
        if(treeSum == null){
            return;
        }
        int frequentTimes = memo.getOrDefault(treeSum, 0) + 1;
        if(frequentTimes == mostFrequentTimes){
            treeSumList.add(treeSum);
        }else if(frequentTimes > mostFrequentTimes){
            treeSumList.clear();
            treeSumList.add(treeSum);
            mostFrequentTimes = frequentTimes;
        }
        memo.put(treeSum, frequentTimes);
    }

    public static void main(String[] args) {
        _508_FindFrequentTreeSum mainProgram = new _508_FindFrequentTreeSum();
        TreeNode _5 = new TreeNode(5);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(-3);
        _5.left = _2;
        _5.right = _3;
        mainProgram.findFrequentTreeSum(_5);
    }

}