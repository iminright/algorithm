/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanhaofan
 * @version _47_PermuteUnique.java, v 0.1 2021年04月11日 6:12 PM wanhaofan
 */
public class _47_PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return result;
        }
        Arrays.sort(nums);
        boolean[] usedInPath = new boolean[length];
        backtrack(nums, usedInPath, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int nums[], boolean[] usedInPath, int depth, ArrayDeque<Integer> pathList){
        if(nums.length == depth){
            result.add(new ArrayList<>(pathList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(usedInPath[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !usedInPath[i - 1]) {
                // 加上usedInPath条件是因为如果前一个节点没有在路径中使用过，哪有三种可能
                // 1.i-1节点刚刚被撤销了，并且i==i-1则说明i节点的结果会与i-1一致，需要【剪枝】
                // 2.i-1节点完全没有使用过，也被【剪枝】了
                // 3.i节点没有被使用过，并且i!=i-1，这种则不需要【剪枝】
                continue;
            }
            pathList.add(nums[i]);
            usedInPath[i] = true;
            backtrack(nums, usedInPath, depth + 1, pathList);
            pathList.removeLast();
            usedInPath[i] = false;
        }
    }

    public static void main(String[] args) {
        _47_PermuteUnique main = new _47_PermuteUnique();
        int[] nums = new int[]{1,2,1};
        System.out.println(main.permuteUnique(nums));
        //[[1, 2, 1], [1, 1, 2], [2, 1, 1]]
    }

}