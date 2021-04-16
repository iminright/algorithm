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
 * @version _47_PermuteUnique_2.java, v 0.1 2021Äê04ÔÂ16ÈÕ 8:49 AM wanhaofan
 */
public class _47_PermuteUnique_2 {

    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, ArrayDeque<Integer> path, int depth){
        if(depth == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, depth + 1);
            used[i] = false;
            path.removeLast();
        }
    }





}