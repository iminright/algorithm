/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _78_Subsets.java, v 0.1 2021Äê04ÔÂ16ÈÕ 8:33 AM wanhaofan
 */
public class _78_Subsets {

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0 ,0 , new ArrayDeque<>());
        return result;
    }

    private void backtrack(int[] nums, int depth, int begin, ArrayDeque<Integer> path){
        if(depth > nums.length){
            return;
        }
        result.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, depth + 1, i + 1, path);
            path.removeLast();
        }
    }

}